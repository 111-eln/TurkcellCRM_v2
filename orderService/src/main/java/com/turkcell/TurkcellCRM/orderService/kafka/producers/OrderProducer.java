package com.turkcell.TurkcellCRM.orderService.kafka.producers;

import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(OrderCreatedEvent orderCreatedEvent){
        LOGGER.info(String.format("Order added =>%s",orderCreatedEvent.toString()));

        Message<OrderCreatedEvent> message = MessageBuilder.withPayload(orderCreatedEvent)
//                .setHeader(KafkaHeaders.TOPIC,"inventory-customer-created")
                .setHeader(KafkaHeaders.TOPIC, "inventory-order-created")
                .build();

        kafkaTemplate.send(message);

    }
}
