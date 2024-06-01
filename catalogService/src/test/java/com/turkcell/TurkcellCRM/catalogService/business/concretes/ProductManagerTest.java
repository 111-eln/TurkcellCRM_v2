package com.turkcell.TurkcellCRM.catalogService.business.concretes;

import com.turkcell.TurkcellCRM.catalogService.business.dtos.requests.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.responses.CreatedProductResponse;
import com.turkcell.TurkcellCRM.catalogService.business.rules.CatalogServiceRules;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.mapping.ModelMapperManager;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.catalogService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.catalogService.entities.Product;
import com.turkcell.TurkcellCRM.catalogService.producers.ProductProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductManagerTest {

    private ProductManager productManager;
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ModelMapper modelMapper;
    private CatalogServiceRules catalogServiceRules;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        modelMapper = new ModelMapper();
        modelMapperService = new ModelMapperManager(modelMapper);
        catalogServiceRules = new CatalogServiceRules(productRepository);
        kafkaTemplate = mock(KafkaTemplate.class);
        ProductProducer productProducer = new ProductProducer(kafkaTemplate);
        productManager = new ProductManager(modelMapperService, productRepository, productProducer, catalogServiceRules);
    }

    @Test
    void deleteById() {
        when(productRepository.findById(1)).thenReturn(Optional.of(new Product()));

        productManager.delete(1);
        assert true;
    }

    @Test
    void deleteWithNotExistsId_ShouldThrowException() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> {
            productManager.delete(1);
        });
    }

    @Test
    void getById() {
        when(productRepository.findById(1)).thenReturn(Optional.of(new Product()));

        productManager.getById(1);
        assert true;
    }

    @Test
    void getByIdWithNotExistsId_ShouldThrowException() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> {
            productManager.getById(1);
        });
    }

    @Test
    void getAll() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> list = new ArrayList<>();

        list.add(product1);
        list.add(product2);

        when(productRepository.findAll()).thenReturn(list);

        List<CreatedProductResponse> result = productManager.getAll();

        assertEquals(2, result.size());
    }

    @Test
    void getAllShouldThrowException() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(BusinessException.class, () -> {
            productManager.getAll();
        });
    }

    @Test
    void add() {
        Product product = new Product();

        product.setTitle("deneme");
        product.setDescription("deneme");
        product.setPrice(1);
        product.setUnitOfStock(1);

        CreateProductsRequest request = modelMapperService.forRequest().map(product, CreateProductsRequest.class);

        when(productRepository.findByTitle("deneme")).thenReturn(Optional.empty());
        when(productRepository.save(product)).thenReturn(new Product());

        productManager.add(request);

        assert true;
    }

    @Test
    void addShouldThrowExceptionForProductExists() {

        Product product = new Product();

        product.setTitle("deneme");
        product.setDescription("deneme");
        product.setPrice(1);
        product.setUnitOfStock(1);
        product.setCreatedDate(LocalDateTime.now());

        CreateProductsRequest request = modelMapperService.forRequest().map(product, CreateProductsRequest.class);

        when(productRepository.findByTitle("deneme")).thenReturn(Optional.of(new Product()));
        when(productRepository.save(product)).thenReturn(new Product());

        assertThrows(BusinessException.class, () -> {
            productManager.add(request);
        });
    }

    @Test
    void update(){

        Product product = new Product();

        product.setTitle("deneme");
        product.setDescription("deneme");
        product.setPrice(1);
        product.setUnitOfStock(1);
        product.setUpdatedDate(LocalDateTime.now());

        CreateProductsRequest request = modelMapperService.forRequest().map(product, CreateProductsRequest.class);

        when(productRepository.findById(1)).thenReturn(Optional.of(new Product()));
        when(productRepository.save(product)).thenReturn(new Product());

        productManager.update(request,1);

        assert true;
    }

    @Test
    void updateShouldThrowExceptionForProductNotExists(){

        Product product = new Product();

        CreateProductsRequest request = modelMapperService.forRequest().map(product, CreateProductsRequest.class);

        when(productRepository.findById(1)).thenReturn(Optional.empty());
        when(productRepository.save(product)).thenReturn(new Product());


        assertThrows(BusinessException.class, () -> {
            productManager.update(request,1);
        });
    }
}