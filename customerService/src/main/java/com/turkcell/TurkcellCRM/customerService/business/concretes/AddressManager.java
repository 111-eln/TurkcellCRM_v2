package com.turkcell.TurkcellCRM.customerService.business.concretes;

import com.turkcell.TurkcellCRM.customerService.business.abstracts.AddressService;
import com.turkcell.TurkcellCRM.customerService.business.rules.AddressBusinessRules;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.AddressRepository;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllAddressResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedAddressResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Address;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;
    private AddressBusinessRules addressBusinessRules;
    @Transactional
    @Override
    public CreatedAddressResponse add(CreateAddressRequest addressRequest) {
        Address address= modelMapperService.forRequest().map(addressRequest,Address.class);
        address.setCreatedDate(LocalDateTime.now());
        Address createdAddress = addressRepository.save(address);
        CreatedAddressResponse response=modelMapperService.forResponse().map(createdAddress, CreatedAddressResponse.class);
        response.setCustomerId(addressRequest.getCustomerId());
        return response;
    }

    @Transactional
    @Override
    public void delete(int id) {
        addressBusinessRules.addressShouldBeExists(id);
        Address currentAddress = this.addressRepository.findById(id).get();
        currentAddress.setDeleted(true);
        currentAddress.setDeletedDate(LocalDateTime.now());
    }

    @Override
    public GetAddressResponse getById(int id) {
        this.addressBusinessRules.addressShouldBeExists(id);
        Address address = addressRepository.findById(id).get();
        GetAddressResponse getAddressResponse = modelMapperService.forResponse().map(address,GetAddressResponse.class);
        return getAddressResponse;
    }

    @Transactional
    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest, int addressId) {
        addressBusinessRules.addressShouldBeExists(addressId);
        Address addressToUpdate= modelMapperService.forRequest().map(updateAddressRequest,Address.class);
        addressToUpdate.setUpdatedDate(LocalDateTime.now());
        addressToUpdate.setId(addressId);
        Address updatedAddress= addressRepository.save(addressToUpdate);
        return modelMapperService.forResponse().map(updatedAddress, UpdatedAddressResponse.class);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {

        this.addressBusinessRules.addressesShouldBeExists();

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream().map(address ->
                modelMapperService.forResponse()
                        .map(address, GetAllAddressResponse.class)).toList();
    }
}