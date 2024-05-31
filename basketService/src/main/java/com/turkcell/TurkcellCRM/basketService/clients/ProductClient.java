package com.turkcell.TurkcellCRM.basketService.clients;

import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import com.turkcell.TurkcellCRM.commonPackage.ProductCreatedEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="catalogservice",url="http://localhost:9029/catalogservice/api/v1/products")
public interface ProductClient {
    @GetMapping("/existProductById/{id}")
    public boolean existProductById(@PathVariable int id);
    @GetMapping("/{id}")
    public GetProductResponse getProductByID(@PathVariable int id);

}
