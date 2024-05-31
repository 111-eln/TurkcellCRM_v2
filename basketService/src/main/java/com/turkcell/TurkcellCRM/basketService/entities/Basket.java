package com.turkcell.TurkcellCRM.basketService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Basket implements Serializable {

    private String id;
    private String customerId;
    private double totalPrice;
    private List<BasketItem> basketItems;

    public Basket(){
        this.basketItems = new ArrayList<>();
        this.id= UUID.randomUUID().toString();
    }
}
