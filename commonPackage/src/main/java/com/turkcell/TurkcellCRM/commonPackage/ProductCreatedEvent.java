package com.turkcell.TurkcellCRM.commonPackage;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
    private String title;

    private String description;

    private int price;

    private int unitOfStock;
}
