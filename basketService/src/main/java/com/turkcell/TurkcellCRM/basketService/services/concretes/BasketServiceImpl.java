package com.turkcell.TurkcellCRM.basketService.services.concretes;

import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.entities.Product;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.basketService.services.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private RedisRepository redisRepository;
    public ProductClient productClient;

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
        basketItem.setProductName(product.getTitle());
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
    public void createOrder(String customerId, String productId) {

    }
}
