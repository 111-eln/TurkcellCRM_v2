package com.turkcell.TurkcellCRM.orderService.dtos.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductRequest {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @NotNull
    private int unitOfStock;
}
