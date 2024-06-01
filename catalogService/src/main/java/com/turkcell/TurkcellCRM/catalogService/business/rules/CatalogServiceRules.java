package com.turkcell.TurkcellCRM.catalogService.business.rules;

import com.turkcell.TurkcellCRM.catalogService.business.messages.Messages;
import com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.catalogService.dataAccess.ProductRepository;
import com.turkcell.TurkcellCRM.catalogService.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogServiceRules {

    private final ProductRepository productRepository;

    public void productShouldBeExists(int productId){
        Optional<Product> product = this.productRepository.findById(productId);
        if (product.isEmpty()){
            throw new BusinessException(Messages.CatalogErrors.PRODUCT_NOT_FOUND);
        }
    }

    public void productAlreadyExists(String title){
        Optional<Product> product = this.productRepository.findByTitle(title);
        if (product.isPresent()){
            throw new BusinessException(Messages.CatalogErrors.PRODUCT_ALREADY_EXISTS);
        }
    }

    public void productsNotExist(){
        List<Product> productList = this.productRepository.findAll();
        if (productList.isEmpty()){
            throw new BusinessException(Messages.CatalogErrors.PRODUCTS_NOT_FOUND);
        }
    }

    public boolean productIsExists(String title){
        Optional<Product> product = this.productRepository.findByTitle(title);
        if (product.isEmpty()){
            throw new BusinessException(Messages.CatalogErrors.PRODUCT_NOT_FOUND);
        }
        else {
            return true;
        }
    }
}
