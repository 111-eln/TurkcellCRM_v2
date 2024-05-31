package com.turkcell.TurkcellCRM.accountService.business.dtos.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAccountRequest {
    @NotNull
    private int accountName;
    @NotNull
    private int accountNumber;
    @NotNull
    private String accountDescription;
    @NotNull
    private String accountInfo;
}
