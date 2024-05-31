package com.turkcell.TurkcellCRM.customerService.dtos.request.create;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAddressRequest {

    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String houseNumber;

    @NotNull
    private String addressDescription;
    
    @NotNull
    private int customerId;

}