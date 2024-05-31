package com.turkcell.TurkcellCRM.commonPackage;
import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "birthDate")
    @NotNull
    private LocalDateTime birthDate;

    @Column(name = "gender")
    @NotNull
    private Gender gender;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "nationalityId")
    @NotNull
    private String nationalityNumber;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "mobilePhone")
    @NotNull
    private String mobilePhone;

    @Column(name = "tax")
    private String tax;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
