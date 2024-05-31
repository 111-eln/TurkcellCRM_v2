package com.turkcell.TurkcellCRM.accountService.business.dtos.Responses;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAccountResponse {
    @NotNull
    private int accountName;

    @NotNull
    private String accountInfo;
}