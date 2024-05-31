package com.turkcell.TurkcellCRM.orderService.api.controllers;

import com.turkcell.TurkcellCRM.orderService.business.abstracts.OrderService;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateOrderResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetOrderResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateOrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orderservice/api/v1/orders")
public class OrderController {
    private OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse add(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.add(createOrderRequest);
    }

    @PutMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateOrderResponse update(@Valid @RequestBody UpdateOrderRequest updateOrderRequest, @PathVariable int orderId) {
        return orderService.update(updateOrderRequest,orderId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetOrderResponse getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetOrderResponse> getAll() {
        return orderService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        orderService.delete(id);
    }

}
