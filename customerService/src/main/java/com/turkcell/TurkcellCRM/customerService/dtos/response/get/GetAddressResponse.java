package com.turkcell.TurkcellCRM.customerService.dtos.response.get;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAddressResponse {
    private String city;
    private String street;
    private String houseNumber;
    private String addressDescription;
}