package com.turkcell.TurkcellCRM.orderService.entities.concretes;

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
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name="addressId")
    private int addressId;

    @Column(name="customerId")
    private int customerId;

    @Column(name = "totalAmount")
    private int totalAmount;


}
