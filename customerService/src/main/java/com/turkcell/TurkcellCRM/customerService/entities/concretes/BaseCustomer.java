package com.turkcell.TurkcellCRM.customerService.entities.concretes;
import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseCustomer extends BaseEntity {

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "customer")
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
