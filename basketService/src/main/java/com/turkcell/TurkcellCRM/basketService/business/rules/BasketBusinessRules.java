package com.turkcell.TurkcellCRM.basketService.business.rules;


import com.turkcell.TurkcellCRM.basketService.business.messages.Messages;
import com.turkcell.TurkcellCRM.basketService.clients.CustomerClient;
import com.turkcell.TurkcellCRM.basketService.clients.ProductClient;
import com.turkcell.TurkcellCRM.basketService.core.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketBusinessRules {
    private final ProductClient productClient;
    private final CustomerClient customerClient;

    public void customerShoulBeExists(String customerId){
        if(!this.customerClient.existCustomerById(Integer.valueOf(customerId))){
            throw new BusinessException(Messages.CustomerErrors.CUSTOMER_NOT_FOUND);
        }
    }
    public void productShouldBeExists(String productId ){
        if(!this.productClient.existProductById( Integer.valueOf(productId))){
            throw new BusinessException(Messages.ProductErrors.PRODUCT_NOT_FOUND);
        }
    }
    public void productShouldHaveStock(int stock){
        if(stock==0){
            throw new BusinessException(Messages.ProductErrors.PRODUCT_OUT_OF_STOCK);
        }

    }



}
