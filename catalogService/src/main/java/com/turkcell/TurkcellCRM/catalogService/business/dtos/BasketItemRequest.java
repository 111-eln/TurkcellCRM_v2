package com.turkcell.TurkcellCRM.catalogService.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasketItemRequest {
    @NotNull
    private String customerId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private int price;

}
