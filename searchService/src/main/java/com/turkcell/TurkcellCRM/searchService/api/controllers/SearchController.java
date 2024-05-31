package com.turkcell.TurkcellCRM.searchService.api.controllers;

//import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.searchService.dtos.BasketItem;
import com.turkcell.TurkcellCRM.searchService.entities.IndividualCustomer;
import com.turkcell.TurkcellCRM.searchService.business.abstracts.SearchService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/searchservice/api/v1/customers")
public class SearchController {
    private SearchService searchService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IndividualCustomer> getAll() {
        return searchService.getAll();
    }
    @PostMapping("/addToBasket")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToBasket(@RequestParam String customerId,@RequestParam String productId) {

        searchService.addToBasket(customerId,productId);
    }


}
