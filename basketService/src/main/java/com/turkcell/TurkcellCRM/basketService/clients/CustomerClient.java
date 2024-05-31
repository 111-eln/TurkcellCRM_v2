package com.turkcell.TurkcellCRM.basketService.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="individualcustomerservice",url="http://localhost:9009/api/v1/customers")
public interface CustomerClient {
    @GetMapping("/{id}")
    public boolean existCustomerById(@PathVariable int id);

}

