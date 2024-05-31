package com.turkcell.TurkcellCRM.customerService.kafka.producers;

import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service

public class IndividualCustomerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualCustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public IndividualCustomerProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(IndividualCustomerCreatedEvent customerCreatedEvent){
        LOGGER.info(String.format("Customer added =>%s",customerCreatedEvent.toString()));

        Message<IndividualCustomerCreatedEvent> message = MessageBuilder.withPayload(customerCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "inventory-customer-created")
                .build();
        kafkaTemplate.send(message);
    }
}