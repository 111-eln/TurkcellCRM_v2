package com.turkcell.TurkcellCRM.searchService.business.abstracts;

import com.turkcell.TurkcellCRM.searchService.dtos.BasketItem;
import com.turkcell.TurkcellCRM.searchService.entities.IndividualCustomer;

import java.util.List;

public interface SearchService {
    void  add(IndividualCustomer customer);
    List<IndividualCustomer> getAll();
    public void addToBasket(String customerId,String productId);
}
