package com.turkcell.TurkcellCRM.searchService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BasketItem implements Serializable {
    private String id;
    private int productId;
    private String title;
    private String description;
    private double price;
    public BasketItem(){
        this.id= UUID.randomUUID().toString();
    }
}
//
//    @NotNull
//    private String title;
//    @NotNull
//    private String description;
//    @NotNull
//    private int price;


