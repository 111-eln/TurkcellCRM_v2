package com.turkcell.TurkcellCRM.orderService.dtos.responses.get;

import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderResponse {
    private int addressId;
    private int customerId;
    private int totalAmount;
    private List<Product> products;
}
