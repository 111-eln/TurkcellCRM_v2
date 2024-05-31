package com.turkcell.TurkcellCRM.basketService.clients;

import com.turkcell.TurkcellCRM.basketService.dtos.CreateOrderRequest;
import com.turkcell.TurkcellCRM.basketService.dtos.CreateOrderResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name="orderservice",url="http://localhost:9015/orderservice/api/v1/orders")
public interface CreateOrderClient {
    @PostMapping
    public CreateOrderResponse add(@Valid @RequestBody CreateOrderRequest createOrderRequest);
}
