package com.turkcell.TurkcellCRM.searchService.kafka;

import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.searchService.business.abstracts.SearchService;
import com.turkcell.TurkcellCRM.searchService.entities.IndividualCustomer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualCustomerConsumer.class);
    private final SearchService searchService;

    @KafkaListener(topics = "inventory-customer-created",groupId="customer-create")
    public void consume(IndividualCustomerCreatedEvent customerCreatedEvent){

        IndividualCustomer customer = new IndividualCustomer();
        customer.setBirthDate(customerCreatedEvent.getBirthDate());
        customer.setGender(customerCreatedEvent.getGender().toString());
        customer.setFatherName(customerCreatedEvent.getFatherName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMotherName(customerCreatedEvent.getMotherName());
        customer.setNationalityNumber(customerCreatedEvent.getNationalityNumber());
        customer.setSecondName(customerCreatedEvent.getSecondName());

        LOGGER.info(String.format("IndividualCustomer consumed =>%s",customer.toString()));

        this.searchService.add(customer);
    }

}