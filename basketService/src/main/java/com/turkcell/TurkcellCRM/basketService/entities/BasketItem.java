package com.turkcell.TurkcellCRM.basketService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BasketItem implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 8164464532246940545L;
    private String id;
    private int productId;
    private String title;
    private String description;
    private double price;

    public BasketItem(){
        this.id= UUID.randomUUID().toString();
    }

}
