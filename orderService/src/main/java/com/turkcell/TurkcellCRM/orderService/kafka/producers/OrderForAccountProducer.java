package com.turkcell.TurkcellCRM.orderService.kafka.producers;

import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedEvent;
import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedForAccountEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderForAccountProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderForAccountProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public OrderForAccountProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(OrderCreatedForAccountEvent orderCreatedForAccountEvent){
        LOGGER.info(String.format("OrderForAccount added =>%s",orderCreatedForAccountEvent.toString()));

        Message<OrderCreatedForAccountEvent> message = MessageBuilder.withPayload(orderCreatedForAccountEvent)
//                .setHeader(KafkaHeaders.TOPIC,"inventory-customer-created")
                .setHeader(KafkaHeaders.TOPIC, "account-order-created")
                .build();

        kafkaTemplate.send(message);

    }
}
