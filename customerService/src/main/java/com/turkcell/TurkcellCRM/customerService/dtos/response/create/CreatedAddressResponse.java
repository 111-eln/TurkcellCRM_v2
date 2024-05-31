package com.turkcell.TurkcellCRM.customerService.dtos.response.create;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedAddressResponse {
    private int customerId;
    private String city;
    private String street;
    private String houseNumber;
}