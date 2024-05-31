package com.turkcell.TurkcellCRM.basketService.services.abstracts;

import com.turkcell.TurkcellCRM.basketService.entities.Basket;

import java.util.Map;

public interface BasketService {
    void add(String customerId,String productId);
    Map<String, Basket> getAllItems();
}
