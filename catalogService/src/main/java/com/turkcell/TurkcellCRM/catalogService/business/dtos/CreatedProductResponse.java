package com.turkcell.TurkcellCRM.catalogService.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedProductResponse {
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private int price;
    @NotNull
    private int unitOfStock;

}
