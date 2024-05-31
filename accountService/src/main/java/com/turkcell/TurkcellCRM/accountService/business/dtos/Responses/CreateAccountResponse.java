package com.turkcell.TurkcellCRM.accountService.business.dtos.Responses;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountResponse {
    @NotNull
    private int accountName;

    @NotNull
    private String accountInfo;
}
