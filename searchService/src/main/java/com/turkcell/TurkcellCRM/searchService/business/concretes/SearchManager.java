package com.turkcell.TurkcellCRM.searchService.business.concretes;

import com.turkcell.TurkcellCRM.searchService.business.abstracts.SearchService;
import com.turkcell.TurkcellCRM.searchService.clients.AddItemToBasketClient;
import com.turkcell.TurkcellCRM.searchService.dtos.BasketItem;
import com.turkcell.TurkcellCRM.searchService.entities.IndividualCustomer;
import com.turkcell.TurkcellCRM.searchService.repositories.SearchProductRepository;
import com.turkcell.TurkcellCRM.searchService.repositories.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchManager implements SearchService {
    public SearchRepository searchRepository;
    public SearchProductRepository searchProductRepository;
    public AddItemToBasketClient addItemToBasketClient;

    @Override
    public void add(IndividualCustomer customer) {
        searchRepository.save(customer);
    }

    @Override
    public List<IndividualCustomer> getAll() {
        return searchRepository.findAll();
    }
    @Override
    public void addToBasket(String customerId,String productId) {
            addItemToBasketClient.addItem(customerId,productId);
    }
}
