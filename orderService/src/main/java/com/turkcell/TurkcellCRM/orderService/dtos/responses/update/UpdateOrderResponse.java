package com.turkcell.TurkcellCRM.orderService.dtos.responses.update;

import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateOrderResponse {
    @NotNull
    private int accountId;
    @NotNull
    private int addressId;
    @NotNull
    private int customerId;
    @NotNull
    private int totalAmount;
    @NotNull
    private List<Product> products;
}
