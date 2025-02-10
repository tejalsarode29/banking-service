package com.bny.banking_application.service;

import java.util.List;

import com.bny.banking_application.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    List<AccountDto> getAllAccounts();

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    void delete(Long id);
}
