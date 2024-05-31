package com.turkcell.TurkcellCRM.commonPackage;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {
    private String city;

    private String street;

    private String houseNumber;

    private String addressDescription;

    private List<Product> products;

    private int totalAmount;
    private int customerId;


}
