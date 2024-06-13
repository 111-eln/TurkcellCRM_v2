package com.turkcell.TurkcellCRM.basketService.business.services.concretes;

import com.turkcell.TurkcellCRM.basketService.business.rules.BasketBusinessRules;
import com.turkcell.TurkcellCRM.basketService.business.services.abstracts.BasketService;
import com.turkcell.TurkcellCRM.basketService.clients.CreateOrderClient;
import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.basketService.dtos.CreateOrderRequest;
import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.entities.Product;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BasketManager implements BasketService {

    private RedisRepository redisRepository;
    private ProductClient productClient;
    private CreateOrderClient orderClient;
    private BasketBusinessRules basketBusinessRules;
    private ModelMapperService modelMapperService;

    @Transactional
    @Override
    public void add(String customerId, String productId) {

        basketBusinessRules.customerShoulBeExists(customerId);
        basketBusinessRules.productShouldBeExists(productId);

        Basket basket = redisRepository.getBasketByCustomerId(customerId);

        if (basket == null) {
            basket = new Basket();
            basket.setCustomerId(customerId);
        }

        GetProductResponse product=productClient.getProductByID(Integer.parseInt(productId));

        basketBusinessRules.productShouldHaveStock(product.getUnitOfStock());

        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(Integer.parseInt(productId));
        basketItem.setTitle(product.getTitle());
        basketItem.setPrice(product.getPrice());
        basket.setCustomerId(customerId);
        basket.setTotalPrice(basket.getTotalPrice()+basketItem.getPrice());
        basket.getBasketItems().add(basketItem);
        redisRepository.addItem(basket);
    }

    @Override
    public Map<String, Basket> getAllItems() {
       return redisRepository.getAllItems();
    }


    @Override
    public void createOrder(String customerId, String productId,int addressId) {

        Basket basket = redisRepository.getBasketByCustomerId(customerId);

        if (basket == null) {
            basket = new Basket();
            basket.setCustomerId(customerId);
        }

        List<BasketItem> basketItems=basket.getBasketItems();
        for (BasketItem item : basketItems) {
            GetProductResponse getProductResponse= productClient.getProductByID(item.getProductId());
           item.setTitle(getProductResponse.getTitle());
           item.setDescription(getProductResponse.getDescription());
           item.setPrice(getProductResponse.getPrice());
        }

        List<Product> productList =basketItems.stream().map(basketItem->  modelMapperService.forResponse().map(basketItem, Product.class)).toList();

        CreateOrderRequest createOrderRequest=new CreateOrderRequest(addressId,Integer.parseInt(customerId),(int)basket.getTotalPrice(),productList);

        orderClient.add(createOrderRequest);
    }
}
