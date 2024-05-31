package com.turkcell.TurkcellCRM.catalogService.producers;


import com.turkcell.TurkcellCRM.commonPackage.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public ProductProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(ProductCreatedEvent productCreatedEvent){
        LOGGER.info(String.format("Product added =>%s",productCreatedEvent.toString()));

        Message<ProductCreatedEvent> message = MessageBuilder.withPayload(productCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "product-created")
                .build();
        kafkaTemplate.send(message);
    }
}
