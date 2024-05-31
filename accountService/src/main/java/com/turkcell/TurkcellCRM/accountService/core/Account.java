package com.turkcell.TurkcellCRM.accountService.core;



import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {


    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "accountStatus")
    private String accountStatus;


    @Column(name = "accountNumber")
    private int accountNumber;

    @Column(name = "accountName")
    private int accountName;

    @Column(name = "adress_id")
    private int adressesId;


}
