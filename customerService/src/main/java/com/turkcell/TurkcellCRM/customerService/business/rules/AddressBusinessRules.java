package com.turkcell.TurkcellCRM.customerService.business.rules;

import com.turkcell.TurkcellCRM.customerService.business.messages.Messages;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.AddressRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AddressBusinessRules {

    private final AddressRepository addressRepository;
    public void addressShouldBeExists(int addressId){
        Optional<Address> foundOptionalAddress = addressRepository.findById(addressId);
        if(foundOptionalAddress.isEmpty()){
            throw new BusinessException(Messages.AddressErrors.ADDRESS_NOT_FOUND);
        }
    }

    public void addressesShouldBeExists(){
        List<Address> addressList = this.addressRepository.findAll();
        if (addressList.isEmpty()){
            throw new BusinessException(Messages.AddressErrors.ADDRESSES_NOT_FOUND);
        }
    }
}