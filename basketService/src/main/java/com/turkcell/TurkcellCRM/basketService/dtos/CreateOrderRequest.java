package com.turkcell.TurkcellCRM.basketService.dtos;

import com.turkcell.TurkcellCRM.basketService.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {

    @NotNull
    private int addressId;
    @NotNull
    private int customerId;
    @NotNull
    private int totalAmount;
    @NotNull
    private List<Product> products;

}

