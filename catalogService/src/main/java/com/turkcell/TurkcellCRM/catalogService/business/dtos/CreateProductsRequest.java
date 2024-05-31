package com.turkcell.TurkcellCRM.catalogService.business.dtos;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductsRequest {
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private int price;
    @NotNull
    private int unitOfStock;
}
