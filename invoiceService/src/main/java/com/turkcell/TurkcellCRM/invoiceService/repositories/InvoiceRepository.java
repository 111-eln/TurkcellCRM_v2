package com.turkcell.TurkcellCRM.invoiceService.repositories;

import com.turkcell.TurkcellCRM.invoiceService.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Order,String> {
}

