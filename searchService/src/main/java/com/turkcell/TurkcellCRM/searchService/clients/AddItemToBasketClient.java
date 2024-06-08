package com.turkcell.TurkcellCRM.searchService.clients;

import com.turkcell.TurkcellCRM.searchService.dtos.BasketItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="basketservice",url="http://localhost:8086/api/v1/basket")
public interface AddItemToBasketClient {
    @PostMapping
    public void addItem(@RequestParam String customerId, @RequestParam String productId);
}
