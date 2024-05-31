package com.turkcell.TurkcellCRM.orderService.dtos.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductResponse {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @NotNull
    private int unitOfStock;
}
