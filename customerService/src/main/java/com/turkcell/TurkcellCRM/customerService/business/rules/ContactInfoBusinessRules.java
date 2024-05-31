package com.turkcell.TurkcellCRM.customerService.business.rules;


import com.turkcell.TurkcellCRM.customerService.business.messages.Messages;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.ContactInfoRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.ContactInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ContactInfoBusinessRules {
    private final ContactInfoRepository contactInfoRepository;
    public void contactInfoShouldBeExists(int addressId){
        Optional<ContactInfo> foundOptionalContactInfo= contactInfoRepository.findById(addressId);
        if(foundOptionalContactInfo.isEmpty()){
            throw new BusinessException(Messages.ContactInfoErrors.CONTACTINFO_NOT_FOUND);
        }
    }

    public void contactInfosShouldBeExists(){
        List<ContactInfo> contactInfoList = this.contactInfoRepository.findAll();
        if (contactInfoList.isEmpty()){
            throw new BusinessException(Messages.ContactInfoErrors.CONTACTINFOS_NOT_FOUND);
        }
    }
}