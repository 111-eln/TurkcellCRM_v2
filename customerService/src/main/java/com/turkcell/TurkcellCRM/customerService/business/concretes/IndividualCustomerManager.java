package com.turkcell.TurkcellCRM.customerService.business.concretes;


import com.turkcell.TurkcellCRM.customerService.business.abstracts.IndividualCustomerService;

import com.turkcell.TurkcellCRM.customerService.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.IndividualCustomerRepository;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateIndividualCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedIndividualCustomerResponse;
import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllIndividualCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetIndividualCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedIndividualCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.IndividualCustomer;
import com.turkcell.TurkcellCRM.customerService.kafka.producers.IndividualCustomerProducer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private IndividualCustomerProducer individualCustomerProducer;


    @Transactional
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

//        individualCustomerBusinessRules.checkToken(authorizationHeader);
        individualCustomerBusinessRules.customerAlreadyExists(createIndividualCustomerRequest.getNationalityNumber());
        individualCustomerBusinessRules.checkMernis(createIndividualCustomerRequest);

        IndividualCustomer customer = modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
        customer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer createdCustomer = individualCustomerRepository.save(customer);

        IndividualCustomerCreatedEvent customerCreatedEvent = modelMapperService.forResponse().map(createdCustomer, IndividualCustomerCreatedEvent.class);

        individualCustomerProducer.sendMessage(customerCreatedEvent);

        return modelMapperService.forResponse().map(createdCustomer, CreatedIndividualCustomerResponse.class);
    }


    @Transactional
    @Override
    public void delete(int id) {

//        individualCustomerBusinessRules.checkToken(authorizationHeader);
        individualCustomerBusinessRules.customerShouldBeExists(id);

        IndividualCustomer currentCustomer = this.individualCustomerRepository.findById(id).get();

        currentCustomer.setDeleted(true);
        currentCustomer.setDeletedDate(LocalDateTime.now());
    }
    @Override
    public boolean existCustomerById(int id) {

        Optional<IndividualCustomer> customer=individualCustomerRepository.findById(id);
        if(customer.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public GetIndividualCustomerResponse getById(int id) {

//        individualCustomerBusinessRules.checkToken(authorizationHeader);
        individualCustomerBusinessRules.customerShouldBeExists(id);

        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        GetIndividualCustomerResponse getCustomerResponse = modelMapperService.forResponse().map(individualCustomer, GetIndividualCustomerResponse.class);

        return getCustomerResponse;
    }

    @Transactional
    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateCustomerRequest, int customerId) {

//        individualCustomerBusinessRules.checkToken(authorizationHeader);
        individualCustomerBusinessRules.customerShouldBeExists(customerId);
        individualCustomerBusinessRules.checkMernis(modelMapperService.forRequest().map(updateCustomerRequest,CreateIndividualCustomerRequest.class)); //TODO: Buraya bakılacak

        IndividualCustomer customerToUpdate = modelMapperService.forRequest().map(updateCustomerRequest, IndividualCustomer.class);

        customerToUpdate.setUpdatedDate(LocalDateTime.now());
        customerToUpdate.setId(customerId);

        IndividualCustomer updatedCustomer = individualCustomerRepository.save(customerToUpdate);

        return modelMapperService.forResponse().map(updatedCustomer, UpdatedIndividualCustomerResponse.class);
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {

//        individualCustomerBusinessRules.checkToken(authorizationHeader);
        individualCustomerBusinessRules.customersShouldBeExist();

        List<IndividualCustomer> customers = individualCustomerRepository.findAll();

        return customers.stream().map(customer ->
                modelMapperService.forResponse()
                        .map(customer, GetAllIndividualCustomerResponse.class)).toList();
    }
}
