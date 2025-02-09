package com.bny.banking_application.service;

import com.bny.banking_application.dto.AccountDto;
import com.bny.banking_application.entities.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
}
