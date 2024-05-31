package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetContactInfoResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String tax;
}