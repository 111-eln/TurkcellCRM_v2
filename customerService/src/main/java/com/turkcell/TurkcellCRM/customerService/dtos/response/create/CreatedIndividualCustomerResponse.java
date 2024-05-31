package com.turkcell.TurkcellCRM.customerService.dtos.response.create;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedIndividualCustomerResponse {
    private String firstName;
    private String lastName;
    private String nationalityNumber;
}
