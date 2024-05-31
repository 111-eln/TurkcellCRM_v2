package com.turkcell.TurkcellCRM.customerService.deleted;

//
//import com.turkcell.TurkcellCRM.customerService.dtos.request.CreateUserJwtRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.SearchCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.request.update.UpdateIndividualCustomerRequest;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.SearchCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.create.CreatedIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetAllIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.get.GetIndividualCustomerResponse;
//import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.dtos.response.update.UpdatedIndividualCustomerResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface CustomerService {
    //todo response ve request yaz
//    List<SearchCustomerResponse> search();
//    String getJwt(CreateUserJwtRequest userInfo);
//    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest customer);// HttpServletRequest request);
//    void delete(int id);
//    GetIndividualCustomerResponse getById(int id);
//    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateCustomerRequest, int customerId);
//    List<GetAllIndividualCustomerResponse> getAll();
}
