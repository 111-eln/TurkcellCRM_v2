package com.turkcell.TurkcellCRM.basketService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String title;

    private String description;

    private int price;
}