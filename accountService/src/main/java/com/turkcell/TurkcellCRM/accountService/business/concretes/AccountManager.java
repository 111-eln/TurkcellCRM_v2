package com.turkcell.TurkcellCRM.accountService.business.concretes;

import com.turkcell.TurkcellCRM.accountService.business.abstracts.AccountService;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.CreateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.UpdateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.CreateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.UpdateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.core.Account;
import com.turkcell.TurkcellCRM.accountService.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.accountService.dataAccess.AccountRepository;
import com.turkcell.TurkcellCRM.accountService.dataAccess.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AccountManager implements AccountService {
   private AccountRepository accountRepository;
   private OrderRepository orderRepository;
   private ModelMapperService modelMapperService;
    @Override
    public CreateAccountResponse add(CreateAccountRequest createAccountRequest) {
       Account account=modelMapperService.forRequest().map(createAccountRequest,Account.class);
       Account dbAccount=accountRepository.save(account);
        return modelMapperService.forResponse().map(dbAccount, CreateAccountResponse.class);
    }

    @Override
    public Account addKafkaAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public UpdateAccountResponse update(UpdateAccountRequest accountRequest, int id) {
        Account account=modelMapperService.forRequest().map(accountRequest,Account.class);
        account.setId(id);
        Account dbAccount=accountRepository.save(account);
        return modelMapperService.forResponse().map(dbAccount, UpdateAccountResponse.class);
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().toList();
    }

    @Override
    public Account addOrderToAccount(Account account) {

        return accountRepository.save(account);
    }
}
