package com.turkcell.TurkcellCRM.catalogService.controllers;

import com.turkcell.TurkcellCRM.catalogService.business.abstracts.ProductService;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.requests.CreateProductsRequest;
import com.turkcell.TurkcellCRM.catalogService.business.dtos.responses.CreatedProductResponse;
import com.turkcell.TurkcellCRM.commonPackage.GetProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/catalogservice/api/v1/products")
public class ProductController {
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@Valid @RequestBody CreateProductsRequest createProductsRequest) {

        return productService.add(createProductsRequest);
    }

    @PutMapping("/productStockControl")
    @ResponseStatus(HttpStatus.OK)
    public boolean controlProductStock(@RequestBody String productTitle) {
        return productService.controlProductStock(productTitle);
    }
    @PutMapping("/productTitleControl")
    @ResponseStatus(HttpStatus.OK)
    public boolean controlProductTitle(@RequestBody String productTitle) {
        return productService.controlProductTitle(productTitle);
    }



    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CreatedProductResponse update(@Valid @RequestBody CreateProductsRequest createProductsRequest, @PathVariable int productId) {
        return productService.update(createProductsRequest,productId);
    }


    @GetMapping("existProductById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean existProductById(@PathVariable int id){ return productService.existProductById(id);};
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getById(@PathVariable int id) {
        return productService.getById(id);
    }




    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CreatedProductResponse> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        productService.delete(id);
    }
}

