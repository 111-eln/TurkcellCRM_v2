package com.turkcell.TurkcellCRM.customerService.business.abstracts;

import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedContactInfoResponse;

import java.util.List;

public interface ContactInfoService {
    CreatedContactInfoResponse add(CreateContactInfoRequest createContactInfoRequest);
    void delete(int id);
    GetContactInfoResponse getById(int id);
    UpdatedContactInfoResponse update(UpdateContactInfoRequest updateContactInfoRequest, int contactInfoId);
    List<GetAllContactInfoResponse> getAll();
}
