package com.turkcell.TurkcellCRM.catalogService.business.concretes;

import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemResponse;
import com.turkcell.TurkcellCRM.commonPackage.ProductCreatedEvent;
import com.turkcell.TurkcellCRM.catalogService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreatedProductResponse;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.catalogService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.catalogService.entities.Product;
import com.turkcell.TurkcellCRM.catalogService.producers.ProductProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    private ProductProducer productProducer;
    @Override
    public CreatedProductResponse add(CreateProductsRequest productsRequest) {
        Product product=modelMapperService.forRequest().map(productsRequest, Product.class);
        Product dbProduct=productRepository.save(product);
        ProductCreatedEvent productCreatedEvent=modelMapperService.forResponse().map(dbProduct, ProductCreatedEvent.class);
        productProducer.sendMessage(productCreatedEvent);
        return modelMapperService.forResponse().map(dbProduct,CreatedProductResponse.class);
    }



    @Override
    public void delete(int id) {

        productRepository.deleteById(id);
    }

    @Override
    public CreatedProductResponse update(CreateProductsRequest productRequest,int id) {
        Product product=modelMapperService.forRequest().map(productRequest, Product.class);
        Product dbProduct=productRepository.save(product);
        dbProduct.setId(id);
        return modelMapperService.forResponse().map(dbProduct,CreatedProductResponse.class);
    }

    @Override
    public boolean controlProductStock(String productTitle) {
        Product product=productRepository.findByTitle(productTitle);
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
        Product product=productRepository.findByTitle(productTitle);
        return product != null;
    }

    @Override
    public List<CreatedProductResponse> getAll() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product ->
                modelMapperService.forResponse()
                        .map(product, CreatedProductResponse.class)).toList();    }

    @Override
    public CreatedProductResponse getById(int id) {
        return modelMapperService.forResponse().map(productRepository.findById(id), CreatedProductResponse.class);
    }
}
