package com.turkcell.TurkcellCRM.basketService.business.services.concretes;

import com.turkcell.TurkcellCRM.basketService.business.rules.BasketBusinessRules;
import com.turkcell.TurkcellCRM.basketService.business.services.abstracts.BasketService;
import com.turkcell.TurkcellCRM.basketService.clients.CustomerClient;
import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.basketService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import com.turkcell.TurkcellCRM.commonPackage.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@AllArgsConstructor
public class BasketManager implements BasketService {

    private RedisRepository redisRepository;
    private ProductClient productClient;
    private CustomerClient customerClient;
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
        basketItem.setProductName(product.getTitle());
        basketItem.setPrice(product.getPrice());
        basket.setCustomerId(customerId);
        basket.setTotalPrice(basket.getTotalPrice()+basketItem.getPrice());
        boolean add = basket.getBasketItems().add(basketItem);
        redisRepository.addItem(basket);
    }

    @Override
    public Map<String, Basket> getAllItems() {
       return redisRepository.getAllItems();
    }
}
