package com.turkcell.TurkcellCRM.customerService.deleted;


//import com.turkcell.TurkcellCRM.customerService.business.messages.CustomerMessages;
//import com.turkcell.TurkcellCRM.customerService.business.rules.CustomerBusinessRules;

import com.turkcell.TurkcellCRM.customerService.business.rules.IndividualCustomerBusinessRules;
//import com.turkcell.TurkcellCRM.customerService.clients.IdentityServiceClient;
//import com.turkcell.TurkcellCRM.customerService.clients.OrderServiceClient;
//import com.turkcell.TurkcellCRM.customerService.clients.TokenControlClient;
        import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping.ModelMapperService;
        import com.turkcell.TurkcellCRM.customerService.dataAccess.IndividualCustomerRepository;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.CreateUserJwtRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.SearchCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateIndividualCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.SearchCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.commonPackage.IndividualCustomerCreatedEvent;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.IndividualCustomer;
//import com.turkcell.TurkcellCRM.customerService.kafka.producers.CustomerProducer;
import com.turkcell.TurkcellCRM.customerService.kafka.producers.IndividualCustomerProducer;
        import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//@Service
//@AllArgsConstructor
public class CustomerManager {//implements CustomerService {
//    //todo bütün crud işlemlerini yap
//    private IndividualCustomerRepository customerRepository;
//    private ModelMapperService modelMapperService;
//    private IndividualCustomerBusinessRules customerBusinnesRules;
//    private IndividualCustomerProducer customerProducer;
////    private OrderServiceClient orderServiceClient;
////    private IdentityServiceClient identityServiceClient;
//    private TokenControlClient tokenControlClient;
//
////    @Override
////    public List<SearchCustomerResponse> search() {
////      //  int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());
//////        return customerRepository.search(request);
////        return orderServiceClient.getOrders();
////    }
////
////    @Override
////    public String getJwt(CreateUserJwtRequest userInfo) {
////        return identityServiceClient.getJwt(userInfo);
////    }
//
//    @Override
//    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createCustomerRequest) {
//
//
//        customerBusinnesRules.customerAlreadyExists(createCustomerRequest.getNationalityNumber());
//        IndividualCustomer customer = modelMapperService.forRequest().map(createCustomerRequest, IndividualCustomer.class);
//        customer.setCreatedDate(LocalDateTime.now());
//        IndividualCustomer createdCustomer = customerRepository.save(customer);
//        IndividualCustomerCreatedEvent customerCreatedEvent=modelMapperService.forResponse().map(createdCustomer, IndividualCustomerCreatedEvent.class);
//        customerProducer.sendMessage(customerCreatedEvent);
//        return modelMapperService.forResponse().map(createdCustomer, CreatedIndividualCustomerResponse.class);
//    }
//
//
//    @Override
//    public void delete(int id) {
//        customerBusinnesRules.customerShouldBeExists(id);
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public GetIndividualCustomerResponse getById(int id) {
//        customerBusinnesRules.customerShouldBeExists(id);
//        IndividualCustomer customer = customerRepository.findById(id).orElse(null);
//        GetIndividualCustomerResponse getCustomerResponse = modelMapperService.forResponse().map(customer, GetIndividualCustomerResponse.class);
//        return getCustomerResponse;
//    }
//
//
//    @Override
//    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateCustomerRequest, int customerId) {
//        customerBusinnesRules.customerShouldBeExists(customerId);
//        IndividualCustomer customerToUpdate = modelMapperService.forRequest().map(updateCustomerRequest, IndividualCustomer.class);
//        customerToUpdate.setUpdatedDate(LocalDateTime.now());
//        customerToUpdate.setId(customerId);
//        IndividualCustomer updatedCustomer = customerRepository.save(customerToUpdate);
//        return modelMapperService.forResponse().map(updatedCustomer, UpdatedIndividualCustomerResponse.class);
//    }
//
//    @Override
//    public List<GetAllIndividualCustomerResponse> getAll() {
//        List<IndividualCustomer> customers = customerRepository.findAll();
//        return customers.stream().map(customer ->
//                modelMapperService.forResponse()
//                        .map(customer, GetAllIndividualCustomerResponse.class)).toList();
//
//    }
}
