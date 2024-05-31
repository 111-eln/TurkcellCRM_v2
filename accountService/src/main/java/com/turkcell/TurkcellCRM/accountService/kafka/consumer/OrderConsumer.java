package com.turkcell.TurkcellCRM.accountService.kafka.consumer;

import com.turkcell.TurkcellCRM.accountService.business.abstracts.AccountService;
import com.turkcell.TurkcellCRM.accountService.core.Account;
import com.turkcell.TurkcellCRM.accountService.core.Order;
import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedForAccountEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    private final AccountService accountService;
    Random random = new Random();


    int randomInt = random.nextInt(2);

    String status = (randomInt == 0) ? "active" : "deactive";

    @KafkaListener(topics = "account-order-created",groupId="accountorder-create")
    public void consume(OrderCreatedForAccountEvent orderCreatedForAccountEvent){

//        Order order = new Order();
//        order.setAddressId(orderCreatedForAccountEvent.getAddressId());
//        order.setCustomerId(orderCreatedForAccountEvent.getCustomerId());
//        order.setId(orderCreatedForAccountEvent.getOrderId());
//        order.setProducts(orderCreatedForAccountEvent.getProducts());
        LOGGER.info(String.format("Account-Order consumed =>%s",orderCreatedForAccountEvent.toString()));
        Account account=new Account();
        accountService.addKafkaAccount(account);
        account.setOrderId(orderCreatedForAccountEvent.getOrderId());
        account.setCustomerId(orderCreatedForAccountEvent.getCustomerId());
        account.setAdressesId(orderCreatedForAccountEvent.getAddressId());
        account.setAccountNumber(account.getId());
        account.setAccountName(account.getAccountNumber());
        account.setAccountStatus(status);
        this.accountService.addOrderToAccount(account);
    }
}
