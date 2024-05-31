package com.turkcell.TurkcellCRM.customerService.deleted;

import com.turkcell.TurkcellCRM.customerService.deleted.CustomerService;
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
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@AllArgsConstructor
//@RequestMapping("/customerservice/api/v1/customers")

//@RequestMapping("/customerservice/customers")
public class CustomerController {
//    private CustomerService customerService;
//    @GetMapping("search")
//    public List<SearchCustomerResponse> search()
//    {
//        return customerService.search();
//    }
//
//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String login(@RequestBody CreateUserJwtRequest userInfo) {
//        return customerService.getJwt(userInfo);
//    }
//    @CrossOrigin
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createCustomerRequest) {
//
//        return customerService.add(createCustomerRequest);
//    }
//
//    @PutMapping("/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public UpdatedIndividualCustomerResponse update(@Valid @RequestBody UpdateIndividualCustomerRequest updateCustomerRequest, @PathVariable int customerId) {
//        return customerService.update(updateCustomerRequest,customerId);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public GetIndividualCustomerResponse getById(@PathVariable int id) {
//        return customerService.getById(id);
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<GetAllIndividualCustomerResponse> getAll() {
//        return customerService.getAll();
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable int id ){
//        customerService.delete(id);
//    }
}