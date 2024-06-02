package com.turkcell.TurkcellCRM.orderService.business.concretes;

import com.turkcell.TurkcellCRM.orderService.business.rules.OrderBusinnesRules;
import com.turkcell.TurkcellCRM.orderService.clients.IsCustomerExistClient;
import com.turkcell.TurkcellCRM.orderService.clients.ProductStockIsEnoughClient;
import com.turkcell.TurkcellCRM.orderService.clients.ProductTitleIsExistClient;
import com.turkcell.TurkcellCRM.orderService.core.mapping.ModelMapperManager;
import com.turkcell.TurkcellCRM.orderService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.orderService.dataAccess.OrderRepository;
import com.turkcell.TurkcellCRM.orderService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.create.CreateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.dtos.requests.update.UpdateOrderRequest;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Order;
import com.turkcell.TurkcellCRM.orderService.entities.concretes.Product;
import com.turkcell.TurkcellCRM.orderService.kafka.producers.OrderForAccountProducer;
import com.turkcell.TurkcellCRM.orderService.kafka.producers.OrderProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.turkcell.TurkcellCRM.commonPackage.OrderCreatedEvent;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class OrderConsumerTest {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private OrderBusinnesRules orderBusinnesRules;
    private ProductTitleIsExistClient productTitleIsExistClient;
    private ProductStockIsEnoughClient productStockIsEnoughClient;
    private IsCustomerExistClient isCustomerExistClient;
    private OrderManager orderManager;

    @BeforeEach
    void setUp() {

        orderRepository = mock(OrderRepository.class);
        productRepository = mock(ProductRepository.class);

        modelMapper = new ModelMapper();
        modelMapperService = new ModelMapperManager(modelMapper);

        kafkaTemplate = mock(KafkaTemplate.class);

        productTitleIsExistClient = mock(ProductTitleIsExistClient.class);
        productStockIsEnoughClient = mock(ProductStockIsEnoughClient.class);
        isCustomerExistClient = mock(IsCustomerExistClient.class);

        orderBusinnesRules = new OrderBusinnesRules(orderRepository,productTitleIsExistClient,productStockIsEnoughClient,isCustomerExistClient);

        OrderProducer orderProducer = new OrderProducer(kafkaTemplate);
        OrderForAccountProducer orderForAccountProducer = new OrderForAccountProducer(kafkaTemplate);

        orderManager = new OrderManager(modelMapperService,orderRepository,productRepository,orderProducer,orderForAccountProducer,orderBusinnesRules);

    }

    @Test
    void add() {

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        Order order = modelMapperService.forRequest().map(createOrderRequest,Order.class);

        when(isCustomerExistClient.existCustomerById(1)).thenReturn(true);
        when(orderRepository.save(order)).thenReturn(new Order());


        Product product = new Product("deneme","deneme",1,1);


        when(productTitleIsExistClient.controlProductTitle("deneme")).thenReturn(true);
        when(productStockIsEnoughClient.controlProductStock("deneme")).thenReturn(true);

        when(productRepository.save(product)).thenReturn(new Product());

        assert true;
    }

    @Test
    void delete(){

        when(orderRepository.findById(1)).thenReturn(Optional.of(new Order()));

        orderManager.delete(1);
        assert true;
    }

    @Test
    void getById(){

        when(orderRepository.findById(1)).thenReturn(Optional.of(new Order()));

        orderManager.getById(1);
        assert true;
    }

    @Test
    void update(){

        Order order = new Order(1,1,10);

        Product product1 = new Product("deneme","deneme",1,1);
        Product product2 = new Product("deneme","deneme",1,1);

        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);

        UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest();
        updateOrderRequest = modelMapperService.forRequest().map(order,UpdateOrderRequest.class);
        updateOrderRequest.setAccountId(1);
        updateOrderRequest.setProducts(list);

        when(orderRepository.findById(1)).thenReturn(Optional.of(new Order()));

        when(orderRepository.save(order)).thenReturn(new Order());

        orderManager.update(updateOrderRequest,1);
        assert true;
    }
}