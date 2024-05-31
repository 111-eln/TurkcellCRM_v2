package com.turkcell.TurkcellCRM.basketService.clients;

import com.turkcell.TurkcellCRM.basketService.dtos.GetProductByIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

//@FeignClient(name="catalogservice",url="http://localhost:9029/catalogservice/api/v1/products")
public interface GetProductByIdClient {
//    @GetMapping("/{id}")
    public GetProductByIdResponse getById(@PathVariable int id);
}