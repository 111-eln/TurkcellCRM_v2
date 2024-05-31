package com.turkcell.TurkcellCRM.catalogService.business.abstracts;

import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemResponse;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreatedProductResponse;
import com.turkcell.TurkcellCRM.catalogService.entities.Product;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductsRequest productsRequest);// HttpServletRequest request);


    void delete(int id);
    Product getProductForBasket(int id);

    CreatedProductResponse update(CreateProductsRequest productRequest,int id);
    boolean controlProductStock(String productTitle);
    boolean controlProductTitle(String productTitle);
    List<CreatedProductResponse> getAll();

    CreatedProductResponse getById(int id);
}
