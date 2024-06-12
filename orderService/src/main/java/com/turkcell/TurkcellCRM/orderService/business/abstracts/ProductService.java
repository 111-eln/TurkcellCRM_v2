package com.turkcell.TurkcellCRM.orderService.business.abstracts;

import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.responses.create.CreateOrderResponse;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;

public interface ProductService {
    Product add(Product product);
}
