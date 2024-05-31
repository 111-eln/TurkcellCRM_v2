package com.turkcell.TurkcellCRM.customerService.business.abstracts;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedAddressResponse;

import java.util.List;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest addressRequest);
    void delete(int id);
    GetAddressResponse getById(int id);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, int addressId);
    List<GetAllAddressResponse> getAll();
}