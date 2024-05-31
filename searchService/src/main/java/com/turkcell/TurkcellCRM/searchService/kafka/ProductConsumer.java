package com.turkcell.TurkcellCRM.searchService.kafka;

import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.commonPackage.ProductCreatedEvent;
import com.turkcell.TurkcellCRM.searchService.business.abstracts.SearchService;
import com.turkcell.TurkcellCRM.searchService.entities.Product;
import com.turkcell.TurkcellCRM.searchService.repositories.SearchProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualCustomerConsumer.class);
    private final SearchProductRepository searchProductRepository;

    @KafkaListener(topics = "product-created",groupId="product-create")
    public void consume(ProductCreatedEvent productCreatedEvent) {
        Product product=new Product();
        product.setTitle(productCreatedEvent.getTitle());
        product.setDescription(productCreatedEvent.getDescription());
        product.setPrice(productCreatedEvent.getPrice());
        LOGGER.info(String.format("Product consumed =>%s",product.toString()));

        this.searchProductRepository.save(product);
    }

    }

