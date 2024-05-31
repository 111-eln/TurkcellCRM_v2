package com.turkcell.TurkcellCRM.commonPackage;

import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import com.turkcell.TurkcellCRM.commonPackage.Customer;
import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "houseNumber")
    @NotNull
    private String houseNumber;

    @Column(name = "addressDescription")
    @NotNull
    private String addressDescription;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
