package com.turkcell.TurkcellCRM.customerService.business.concretes;

import com.turkcell.TurkcellCRM.customerService.business.abstracts.ContactInfoService;
import com.turkcell.TurkcellCRM.customerService.business.rules.ContactInfoBusinessRules;

import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.ContactInfoRepository;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.ContactInfo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactInfoManager implements ContactInfoService {
    private ContactInfoRepository contactInfoRepository;
    private ModelMapperService modelMapperService;
    private ContactInfoBusinessRules contactInfoBusinnesRules;
    @Transactional
    @Override
    public CreatedContactInfoResponse add(CreateContactInfoRequest createContactInfoRequest) {
        ContactInfo contactInfo = modelMapperService.forRequest().map(createContactInfoRequest,ContactInfo.class);
        contactInfo.setCreatedDate(LocalDateTime.now());
        ContactInfo createdContactInfo = contactInfoRepository.save(contactInfo);
        return modelMapperService.forResponse().map(createdContactInfo, CreatedContactInfoResponse.class);
    }

    @Transactional
    @Override
    public void delete(int id) {
        contactInfoBusinnesRules.contactInfoShouldBeExists(id);
        ContactInfo currentContactInfo = this.contactInfoRepository.findById(id).get();
        currentContactInfo.setDeleted(true);
        currentContactInfo.setDeletedDate(LocalDateTime.now());
    }

    @Override
    public GetContactInfoResponse getById(int id) {
        this.contactInfoBusinnesRules.contactInfoShouldBeExists(id);
        ContactInfo contactInfo = contactInfoRepository.findById(id).get();
        GetContactInfoResponse getContactInfoResponse = modelMapperService.forResponse().map(contactInfo,GetContactInfoResponse.class);
        return getContactInfoResponse;
    }

    @Transactional
    @Override
    public UpdatedContactInfoResponse update(UpdateContactInfoRequest updateContactInfoRequest, int contactInfoId) {
        contactInfoBusinnesRules.contactInfoShouldBeExists(contactInfoId);
        ContactInfo contactInfoToUpdate= modelMapperService.forRequest().map(updateContactInfoRequest,ContactInfo.class);
        contactInfoToUpdate.setUpdatedDate(LocalDateTime.now());
        contactInfoToUpdate.setId(contactInfoId);
        ContactInfo updatedContactInfo = contactInfoRepository.save(contactInfoToUpdate);
        return modelMapperService.forResponse().map(updatedContactInfo, UpdatedContactInfoResponse.class);
    }

    @Override
    public List<GetAllContactInfoResponse> getAll() {

        this.contactInfoBusinnesRules.contactInfosShouldBeExists();

        List<ContactInfo> contactInfos = contactInfoRepository.findAll();
        return contactInfos.stream().map(contactInfo -> modelMapperService.forResponse().map(contactInfo,GetAllContactInfoResponse.class)).toList();
    }
}