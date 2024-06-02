package com.turkcell.TurkcellCRM.accountService.business.concretes;

import com.turkcell.TurkcellCRM.accountService.business.concretes.AccountManager;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.CreateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.UpdateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.UpdateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.core.Account;
import com.turkcell.TurkcellCRM.accountService.crossCuttingConcerns.mapping.ModelMapperManager;
import com.turkcell.TurkcellCRM.accountService.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.accountService.dataAccess.AccountRepository;
import com.turkcell.TurkcellCRM.accountService.dataAccess.OrderRepository;
import com.turkcell.TurkcellCRM.accountService.kafka.consumer.OrderConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountManagerTest {
    private AccountManager accountManager;
    private AccountRepository accountRepository;
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;
    private KafkaTemplate<String, Object> kafkaTemplate;

    private ModelMapperService modelMapperService;
    @BeforeEach
    void setUp(){
        accountRepository = mock(AccountRepository.class);
        modelMapper = new ModelMapper();
        modelMapperService=new ModelMapperManager(modelMapper);
        kafkaTemplate = mock(KafkaTemplate.class);
        OrderConsumer consumer = new OrderConsumer(accountManager);
        accountManager = new AccountManager(accountRepository,orderRepository,modelMapperService);

    }

    @Test
    void addOrderToAccount(){
        Account account=new Account();
        account.setAccountStatus("active");
        account.setAccountNumber(4562);
        account.setOrderId(1);
        account.setCustomerId(1);
        account.setAdressesId(1);
        account.setAccountName(4562);
        when(accountManager.addOrderToAccount(account)).thenReturn(account);

    }

    @Test
    void getaAll(){
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> list = new ArrayList<>();

        list.add(account1);
        list.add(account2);
        when(accountRepository.findAll()).thenReturn(list);
        List<Account> result = accountManager.getAll();

        assertEquals(2, result.size());
    }

    @Test
    void update(){
        Account account=new Account();
        account.setAccountStatus("active");
        account.setAccountNumber(4562);
        account.setOrderId(1);
        account.setCustomerId(1);
        account.setAdressesId(1);
        account.setAccountName(4562);
        account.setId(1);

        UpdateAccountRequest request=modelMapperService.forRequest().map(account, UpdateAccountRequest.class);
        request.setAccountName(45630);
        request.setAccountInfo("updated");
        request.setAccountDescription("updatedDescr");
        request.setAccountNumber(45630);
        Account response=modelMapperService.forResponse().map(request, Account.class);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        when(accountRepository.save(response)).thenReturn(new Account());
        accountManager.update(request,1);

    }

    @Test
    void addKafkaAccount(){
        Account account=new Account();
        account.setAccountStatus("active");
        account.setAccountNumber(4562);
        account.setOrderId(1);
        account.setCustomerId(1);
        account.setAdressesId(1);
        account.setAccountName(4562);
        account.setId(1);
        when(accountRepository.save(account)).thenReturn(new Account());

    }


    @Test
    void add(){
        CreateAccountRequest request=new CreateAccountRequest();
        request.setAccountNumber(4562);
        request.setAccountName(4562);
        Account account=modelMapperService.forRequest().map(request,Account.class);
        when(accountRepository.save(account)).thenReturn(new Account());
        accountManager.add(request);


    }
}
