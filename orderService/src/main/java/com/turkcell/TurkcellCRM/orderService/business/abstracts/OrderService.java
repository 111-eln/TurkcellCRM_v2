package com.turkcell.TurkcellCRM.orderService.business.abstracts;

import com.turkcell.TurkcellCRM.orderService.clients.IsCustomerExistClient;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateProductRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateOrderResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetOrderResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.get.GetProductResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateOrderResponse;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.update.UpdateProductResponse;

import java.util.List;

public interface OrderService {
    CreateOrderResponse add(CreateOrderRequest orderRequest);
    void delete(int id);
    GetOrderResponse getById(int id);
    UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest, int orderId);
    List<GetOrderResponse> getAll();
}
