package com.turkcell.TurkcellCRM.orderService.dtos.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductResponse {
    @NotNull
    private String title;

}
