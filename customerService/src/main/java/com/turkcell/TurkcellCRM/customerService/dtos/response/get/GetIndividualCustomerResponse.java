package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import com.turkcell.TurkcellCRM.commonPackage.Gender;
import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetIndividualCustomerResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private String nationalNumber;
}