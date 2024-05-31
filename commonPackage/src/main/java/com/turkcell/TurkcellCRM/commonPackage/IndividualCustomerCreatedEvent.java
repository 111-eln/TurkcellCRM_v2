package com.turkcell.TurkcellCRM.commonPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualCustomerCreatedEvent {

    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;

    private String nationalityNumber;


}
