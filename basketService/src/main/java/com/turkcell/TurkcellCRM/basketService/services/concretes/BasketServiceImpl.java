package com.turkcell.TurkcellCRM.basketService.services.concretes;

import com.turkcell.TurkcellCRM.basketService.clients.CreateOrderClient;
import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.basketService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.basketService.dtos.CreateOrderRequest;
import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.entities.Product;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.basketService.services.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private RedisRepository redisRepository;
    public ProductClient productClient;
    public CreateOrderClient orderClient;
    public ModelMapperService modelMapperService;

    @Override
    public void add(String customerId, String productId) {

        Basket basket = redisRepository.getBasketByCustomerId(customerId);

        if (basket == null) {
            basket = new Basket();
            basket.setCustomerId(customerId);
        }
        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(Integer.parseInt(productId));
        Product product=productClient.getProductForBasket(Integer.parseInt(productId));
        if(product==null){
            throw new BusinessException("Bu id ile product bulunmamaktadir");
        }
        basketItem.setTitle(product.getTitle());
        basketItem.setPrice(product.getPrice());
        basketItem.setDescription(product.getDescription());
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
//       createOrderRequest.setAddressId(addressId);
//       createOrderRequest.setCustomerId(Integer.parseInt(customerId));
//       createOrderRequest.setTotalAmount((int)basket.getTotalPrice());


        List<BasketItem> basketItems=basket.getBasketItems();

        List<Product> productList=basketItems.stream().map(basketItem->  modelMapperService.forResponse().map(basketItem, Product.class)).toList();

        CreateOrderRequest createOrderRequest=new CreateOrderRequest(addressId,Integer.parseInt(customerId),(int)basket.getTotalPrice(),productList);


//        List<Product> productList=new ArrayList<>();
//        for (int i = 0; i < basket.getBasketItems().size(); i++) {
//            productList.add(null);
//        }
//       for (int i=1;i<basket.getBasketItems().size();i++) {
//           productList.get(1).setDescription(basket.getBasketItems().get(1).getDescription());
//           productList.get(1).setProductName(basket.getBasketItems().get(1).getProductName());
//           productList.get(1).setPrice((int)basket.getBasketItems().get(1).getPrice());        }
//       createOrderRequest.setProducts(productList);
       orderClient.add(createOrderRequest);
    }
}
