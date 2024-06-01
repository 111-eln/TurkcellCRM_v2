package com.turkcell.TurkcellCRM.catalogService.dataAccess;

import com.turkcell.TurkcellCRM.catalogService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByTitle(String productTitle);
}
