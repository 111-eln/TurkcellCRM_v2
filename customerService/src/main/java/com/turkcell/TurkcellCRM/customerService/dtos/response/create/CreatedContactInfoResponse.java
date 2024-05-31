package com.turkcell.TurkcellCRM.customerService.dtos.response.create;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedContactInfoResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String tax;
}
