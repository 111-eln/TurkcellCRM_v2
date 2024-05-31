package com.turkcell.TurkcellCRM.customerService.adapter;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;

public interface MernisService {
    public boolean checkIsRealPerson(CreateIndividualCustomerRequest createIndividualCustomerRequest);
}
