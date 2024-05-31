package com.turkcell.TurkcellCRM.accountService.business.abstracts;


import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.CreateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.UpdateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.CreateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.UpdateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.core.Account;

import java.util.List;

public interface AccountService {
    CreateAccountResponse add(CreateAccountRequest account);
    Account addKafkaAccount(Account account);
    UpdateAccountResponse update(UpdateAccountRequest accountRequest,int id);
    List<Account> getAll();
    Account addOrderToAccount(Account account);
}
