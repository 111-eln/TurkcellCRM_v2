package com.turkcell.TurkcellCRM.invoiceService.entities;



import com.turkcell.TurkcellCRM.commonPackage.Address;
import com.turkcell.TurkcellCRM.commonPackage.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("filter-order")
public class Order {

    @Id
    private String id;
    @Field(name="city")
    private String city;
    @Field(name="street")
    private String street;
    @Field(name="houseNumber")
    private String houseNumber;
    @Field(name="addressDescription")
    private String addressDescription;
    @Field(name="products")
    private List<Product> products;
    @Field(name="totalAmount")
    private int totalAmount;
//    @Field(name="customerId")
//    private int customerId;

}
