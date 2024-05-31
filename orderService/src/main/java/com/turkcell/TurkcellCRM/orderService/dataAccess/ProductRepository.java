package com.turkcell.TurkcellCRM.orderService.dataAccess;

import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByTitle(String title);
}
