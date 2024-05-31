package com.turkcell.TurkcellCRM.accountService.dataAccess;

import com.turkcell.TurkcellCRM.accountService.core.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account,Integer> {
}
