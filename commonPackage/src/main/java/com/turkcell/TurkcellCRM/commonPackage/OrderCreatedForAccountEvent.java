package com.turkcell.TurkcellCRM.commonPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedForAccountEvent {
    private int addressId;
    private int customerId;
    private int orderId;
    private List<Product> products;
}
