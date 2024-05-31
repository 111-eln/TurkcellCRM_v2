package com.turkcell.TurkcellCRM.customerService.entities.concretes;

import com.turkcell.TurkcellCRM.commonPackage.enums.Roles;
import com.turkcell.TurkcellCRM.customerService.entities.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "individualCustomers")
public class IndividualCustomer extends BaseCustomer {

//    @Column(name = "individualId" , insertable = false , updatable = false)
//    private Integer individualId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private LocalDateTime birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "role")
    private Roles role;

    @Column(name = "nationalityId")
    private String nationalityNumber;
}
