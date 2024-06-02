package com.turkcell.TurkcellCRM.basketService.business.services.concretes;

import com.turkcell.TurkcellCRM.basketService.business.rules.BasketBusinessRules;
import com.turkcell.TurkcellCRM.basketService.clients.CreateOrderClient;
import com.turkcell.TurkcellCRM.basketService.clients.CustomerClient;
import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.basketService.core.mapping.ModelMapperManager;
import com.turkcell.TurkcellCRM.basketService.core.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.basketService.entities.Basket;
import com.turkcell.TurkcellCRM.basketService.entities.BasketItem;
import com.turkcell.TurkcellCRM.basketService.repositories.RedisRepository;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BasketManagerTest {
    @Mock
    private RedisRepository redisRepository;

    @Mock
    private ProductClient productClient;

    @Mock
    private CustomerClient customerClient;

    @Mock
    private CreateOrderClient orderClient;

    @Mock
    private BasketBusinessRules basketBusinessRules;

    private BasketManager basketManager;

    private ModelMapperService modelMapperService;


    @BeforeEach
    void setUp() {
        this.modelMapperService=new ModelMapperManager(new ModelMapper());

        MockitoAnnotations.openMocks(this);
        basketManager = new BasketManager(redisRepository,productClient,orderClient,basketBusinessRules,modelMapperService);

    }

    @Test
    void Add() {
        String customerId = "1";
        String productId = "2";

        when(redisRepository.getBasketByCustomerId(customerId)).thenReturn(null);

        GetProductResponse productResponse = new GetProductResponse();
        productResponse.setTitle("Product Title");
        productResponse.setPrice(1000);
        productResponse.setUnitOfStock(10);
        when(productClient.getProductByID(Integer.parseInt(productId))).thenReturn(productResponse);

        doNothing().when(basketBusinessRules).customerShoulBeExists(customerId);
        doNothing().when(basketBusinessRules).productShouldBeExists(productId);
        doNothing().when(basketBusinessRules).productShouldHaveStock(productResponse.getUnitOfStock());

        basketManager.add(customerId, productId);
        assert true;
    }
    @Test
    void addThrowsCustomerShouldBeExist() {
        String customerId = "1";
        String productId = "2";

        when(redisRepository.getBasketByCustomerId(customerId)).thenReturn(null);

        GetProductResponse productResponse = new GetProductResponse();
        productResponse.setTitle("Product Title");
        productResponse.setPrice(1000);
        productResponse.setUnitOfStock(10);
        when(productClient.getProductByID(Integer.parseInt(productId))).thenReturn(productResponse);

        when(customerClient.existCustomerById(Integer.valueOf(customerId))).thenReturn(true);

        doThrow(new BusinessException("Customer not exists")).when(basketBusinessRules).productShouldBeExists(productId);
        doNothing().when(basketBusinessRules).productShouldHaveStock(productResponse.getUnitOfStock());
        assertThrows(BusinessException.class, () -> {
            basketManager.add(customerId,productId);
        });


    }
    @Test
    void addThrowsProductNotExists() {
        String customerId = "1";
        String productId = "2";

        when(redisRepository.getBasketByCustomerId(customerId)).thenReturn(null);

        GetProductResponse productResponse = new GetProductResponse();
        productResponse.setTitle("Product Title");
        productResponse.setPrice(1000);
        productResponse.setUnitOfStock(10);
        when(productClient.getProductByID(Integer.parseInt(productId))).thenReturn(productResponse);

        doNothing().when(basketBusinessRules).customerShoulBeExists(customerId);
        doThrow(new BusinessException("")).when(basketBusinessRules).productShouldBeExists(productId);
        doNothing().when(basketBusinessRules).productShouldHaveStock(productResponse.getUnitOfStock());

        assertThrows(BusinessException.class, () -> {
            basketManager.add(customerId,productId);
        });


    }
    @Test
    void addThrowsOutOFStockException() {
        String customerId = "1";
        String productId = "2";

        when(redisRepository.getBasketByCustomerId(customerId)).thenReturn(null);

        GetProductResponse productResponse = new GetProductResponse();
        productResponse.setTitle("Product Title");
        productResponse.setPrice(1000);
        productResponse.setUnitOfStock(10);
        when(productClient.getProductByID(Integer.parseInt(productId))).thenReturn(productResponse);

        doNothing().when(basketBusinessRules).customerShoulBeExists(customerId);
        doNothing().when(basketBusinessRules).productShouldBeExists(productId);
        doThrow(new BusinessException("")).when(basketBusinessRules).productShouldHaveStock(productResponse.getUnitOfStock());

        assertThrows(BusinessException.class, () -> {
            basketManager.add(customerId,productId);
        });
    }

    @Test
    void GetAllItems() {
        Map<String, Basket> expectedItems = new HashMap<>();
        when(redisRepository.getAllItems()).thenReturn(expectedItems);

        Map<String, Basket> actualItems = basketManager.getAllItems();

        assertEquals(expectedItems, actualItems);

    }

    @Test
    void CreateOrder() {
        String customerId = "1";
        BasketItem basketItem1 = new BasketItem();
        BasketItem basketItem2 = new BasketItem();
        List<BasketItem> basketItems = Arrays.asList(basketItem1, basketItem2);
        Basket basket = new Basket();
        basket.setBasketItems(basketItems);
        modelMapperService=new ModelMapperManager(new ModelMapper());


        when(redisRepository.getBasketByCustomerId(customerId)).thenReturn(basket);

        basketManager.createOrder(customerId,"1",1);

        assert true;


    }
}
