package com.turkcell.TurkcellCRM.searchService.repositories;

import com.turkcell.TurkcellCRM.searchService.entities.IndividualCustomer;
import com.turkcell.TurkcellCRM.searchService.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchProductRepository extends MongoRepository<Product,Integer> {
    Product findByTitle(String productTitle);
}
