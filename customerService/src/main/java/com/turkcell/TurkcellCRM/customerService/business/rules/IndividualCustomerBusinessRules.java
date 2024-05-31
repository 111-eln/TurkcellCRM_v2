package com.turkcell.TurkcellCRM.customerService.business.rules;

import com.turkcell.TurkcellCRM.customerService.adapter.MernisService;
import com.turkcell.TurkcellCRM.customerService.business.messages.Messages;
//import com.turkcell.TurkcellCRM.customerService.clients.TokenControlClient;
import com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.IndividualCustomerRepository;
import com.turkcell.TurkcellCRM.customerService.dtos.request.create.CreateIndividualCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final MernisService individualCustomerCheck;
//    private TokenControlClient tokenControlClient;
    public void customerShouldBeExists(int customerId) {
        Optional<IndividualCustomer> foundOptionalCustomer = individualCustomerRepository.findById(customerId);
        if (foundOptionalCustomer.isEmpty()) {
            throw new BusinessException(Messages.IndividualCustomerErrors.CUSTOMER_NOT_FOUND);
        }
    }

    public void customerAlreadyExists(String nationalityNumber) {
        Optional<IndividualCustomer> foundOptionalCustomer = individualCustomerRepository.findByNationalityNumber(nationalityNumber);
        if (!foundOptionalCustomer.isEmpty()) {
            throw new BusinessException(Messages.IndividualCustomerErrors.CUSTOMER_ALREADY_EXISTS);
        }
    }

    public void customersShouldBeExist(){
        List<IndividualCustomer> individualCustomerList = this.individualCustomerRepository.findAll();
        if (individualCustomerList.isEmpty()){
            throw new BusinessException(Messages.IndividualCustomerErrors.CUSTOMERS_NOT_FOUND);
        }
    }

    public void checkMernis(CreateIndividualCustomerRequest createIndividualCustomerRequest){
        boolean deneme = individualCustomerCheck.checkIsRealPerson(createIndividualCustomerRequest);
        if (!deneme){
            throw new BusinessException(Messages.MernisMessages.CUSTOMER_NOT_EXISTS);
        }
    }

//    public void checkToken(String token){
//        if(!tokenControlClient.tokenControl(token.substring("Bearer ".length()))){
//            throw new BusinessException(Messages.ClientMessages.ADMIN_IS_AUTHENTICATED);
//        }
    }
