package com.turkcell.TurkcellCRM.orderService.dtos.requests.create;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private int price;



}
