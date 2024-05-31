package com.turkcell.TurkcellCRM.basketService.services.concretes;

import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.basketService.services.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private RedisRepository redisRepository;

    @Override
    public void add(String customerId, String productId) {

        Basket basket = redisRepository.getBasketByCustomerId(customerId);

        if (basket == null) {
            basket = new Basket();
            basket.setCustomerId(customerId);
        }
        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(Integer.parseInt(productId));
        basketItem.setProductName("Modem");
        basketItem.setPrice(2000);
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
