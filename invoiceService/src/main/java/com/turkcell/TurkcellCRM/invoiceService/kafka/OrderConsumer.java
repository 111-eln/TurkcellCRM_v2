package com.turkcell.TurkcellCRM.invoiceService.kafka;

import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedEvent;
import com.turkcell.TurkcellCRM.invoiceService.business.InvoiceService;
import com.turkcell.TurkcellCRM.invoiceService.entities.Order;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    private final InvoiceService invoiceService;
    @KafkaListener(topics = "inventory-order-created",groupId="order-create")
    public void consume(OrderCreatedEvent orderCreatedEvent){
        Order order = new Order();
        order.setProducts(orderCreatedEvent.getProducts());
        order.setHouseNumber(orderCreatedEvent.getHouseNumber());
        order.setCity(orderCreatedEvent.getCity());
        order.setStreet(orderCreatedEvent.getStreet());
        order.setTotalAmount(orderCreatedEvent.getTotalAmount());
        order.setAddressDescription(orderCreatedEvent.getAddressDescription());
//        order.setCustomerId(orderCreatedEvent.getCustomerId());

        LOGGER.info(String.format("Order consumed =>%s",order.toString()));
        this.invoiceService.add(order);
    }

}
