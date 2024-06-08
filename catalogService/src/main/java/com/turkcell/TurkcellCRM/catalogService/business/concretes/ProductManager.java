package com.turkcell.TurkcellCRM.catalogService.business.concretes;

import com.turkcell.TurkcellCRM.catalogService.business.rules.CatalogServiceRules;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import com.turkcell.TurkcellCRM.commonPackage.ProductCreatedEvent;
import com.turkcell.TurkcellCRM.catalogService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.requests.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.responses.CreatedProductResponse;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.catalogService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.catalogService.entities.Product;
import com.turkcell.TurkcellCRM.catalogService.producers.ProductProducer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    private ProductProducer productProducer;
    private CatalogServiceRules catalogServiceRules;

    @Transactional
    @Override
    public CreatedProductResponse add(CreateProductsRequest productsRequest) {

        catalogServiceRules.productAlreadyExists(productsRequest.getTitle());

        Product product=modelMapperService.forRequest().map(productsRequest, Product.class);

        Product dbProduct=productRepository.save(product);

        ProductCreatedEvent productCreatedEvent=modelMapperService.forResponse().map(dbProduct, ProductCreatedEvent.class);

        productProducer.sendMessage(productCreatedEvent);

        return modelMapperService.forResponse().map(dbProduct,CreatedProductResponse.class);
    }

    @Transactional
    @Override
    public void delete(int id) {

        catalogServiceRules.productShouldBeExists(id);

        Product product = productRepository.findById(id).get();

        product.setDeletedDate(LocalDateTime.now());
        product.setDeleted(true);

        productRepository.save(product);
    }

    @Transactional
    @Override
    public CreatedProductResponse update(CreateProductsRequest productRequest,int id) {

        catalogServiceRules.productShouldBeExists(id);

        Product product=modelMapperService.forRequest().map(productRequest, Product.class);

        Product dbProduct=productRepository.save(product);

        dbProduct.setId(id);

        return modelMapperService.forResponse().map(dbProduct,CreatedProductResponse.class);
    }

    @Transactional
    @Override
    public boolean controlProductStock(String productTitle) {

        catalogServiceRules.productIsExists(productTitle);

        Product product=productRepository.findByTitle(productTitle).get();

        if(product.getUnitOfStock()>0){
            product.setUnitOfStock(product.getUnitOfStock()-1);
            product.setId(product.getId());
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean controlProductTitle(String productTitle) {

        catalogServiceRules.productIsExists(productTitle);

        Product product=productRepository.findByTitle(productTitle).get();

        return product != null;
    }

    @Override
    public List<CreatedProductResponse> getAll() {

        catalogServiceRules.productsNotExist();

        List<Product> products=productRepository.findAll();

        return products.stream().map(product ->
                modelMapperService.forResponse()
                        .map(product, CreatedProductResponse.class)).toList();    }

    @Override
    public GetProductResponse getById(int id) {

        catalogServiceRules.productShouldBeExists(id);
        Optional<Product> product = this.productRepository.findById(id);
        GetProductResponse getProductResponse = new GetProductResponse(product.get().getTitle(),product.get().getDescription(),product.get().getPrice(),product.get().getUnitOfStock());
        return getProductResponse;
    }

    public boolean existProductById(int id){

        catalogServiceRules.productShouldBeExists(id);

        Optional<Product> product=productRepository.findById(id);

        return product.isPresent();
    }
}
