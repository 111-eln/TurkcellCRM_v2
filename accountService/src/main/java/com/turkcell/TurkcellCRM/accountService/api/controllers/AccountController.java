package com.turkcell.TurkcellCRM.accountService.api.controllers;

import com.turkcell.TurkcellCRM.accountService.business.abstracts.AccountService;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.CreateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Requests.UpdateAccountRequest;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.CreateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.business.dtos.Responses.UpdateAccountResponse;
import com.turkcell.TurkcellCRM.accountService.core.Account;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/acountservice/api/v1/accounts")
public class AccountController {
    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountResponse add(@Valid @RequestBody CreateAccountRequest account) {
        return accountService.add(account);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateAccountResponse update(@Valid @RequestBody UpdateAccountRequest account,int id) {
        return accountService.update(account,id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAll() {
        return accountService.getAll();
    }

}
