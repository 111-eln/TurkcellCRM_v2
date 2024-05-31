package com.turkcell.TurkcellCRM.catalogService.business.abstracts;

import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemResponse;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreatedProductResponse;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductsRequest productsRequest);// HttpServletRequest request);


    void delete(int id);
    //    GetIndividualCustomerResponse getById(int id, String authorizationHeader);
    CreatedProductResponse update(CreateProductsRequest productRequest,int id);
    boolean controlProductStock(String productTitle);
    boolean controlProductTitle(String productTitle);
    List<CreatedProductResponse> getAll();

    CreatedProductResponse getById(int id);
}
