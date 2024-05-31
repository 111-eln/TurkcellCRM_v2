package com.turkcell.TurkcellCRM.customerService.api.controllers;


import com.turkcell.TurkcellCRM.customerService.business.abstracts.ContactInfoService;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedContactInfoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/contactinfos")
public class ContactInfoController {
    private ContactInfoService contactInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedContactInfoResponse add(@Valid @RequestBody CreateContactInfoRequest createContactInfoRequest) {
        return contactInfoService.add(createContactInfoRequest);
    }

    @PutMapping("/{contactInfoId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedContactInfoResponse update(@Valid @RequestBody UpdateContactInfoRequest updateContactInfoRequest, @PathVariable int contactInfoId) {
        return contactInfoService.update(updateContactInfoRequest,contactInfoId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetContactInfoResponse getById(@PathVariable int id) {
        return contactInfoService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllContactInfoResponse> getAll() {
        return contactInfoService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        contactInfoService.delete(id);
    }
}