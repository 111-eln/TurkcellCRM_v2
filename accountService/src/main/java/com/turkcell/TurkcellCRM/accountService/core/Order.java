package com.turkcell.TurkcellCRM.accountService.core;

import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import com.turkcell.TurkcellCRM.commonPackage.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

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

//    @Column(name="products")
//    private List<Product> products;
}
