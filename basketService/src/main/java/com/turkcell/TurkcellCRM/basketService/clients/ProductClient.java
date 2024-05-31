package com.turkcell.TurkcellCRM.basketService.clients;

import com.turkcell.TurkcellCRM.basketService.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="catalogservice",url="http://localhost:9029/catalogservice/api/v1/products")
public interface ProductClient {
    @GetMapping("/getProductForBasket/{id}")
    public Product getProductForBasket(@PathVariable int id);
}
