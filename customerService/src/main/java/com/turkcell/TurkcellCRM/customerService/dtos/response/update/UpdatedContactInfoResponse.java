package com.turkcell.TurkcellCRM.customerService.dtos.response.update;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatedContactInfoResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String tax;
}