package com.turkcell.TurkcellCRM.catalogService.business.abstracts;

import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.BasketItemResponse;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.CreatedProductResponse;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductsRequest productsRequest);// HttpServletRequest request);


    void delete(int id);
    //    GetIndividualCustomerResponse getById(int id, String authorizationHeader);
    CreatedProductResponse update(CreateProductsRequest productRequest,int id);
    boolean controlProductStock(String productTitle);
    boolean controlProductTitle(String productTitle);
    List<CreatedProductResponse> getAll();
     boolean existProductById(int id);
    GetProductResponse getById(int id);
}
