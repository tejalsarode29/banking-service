package com.bny.banking_application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bny.banking_application.dto.AccountDto;
import com.bny.banking_application.entities.Account;
import com.bny.banking_application.mapper.AccountMapper;
import com.bny.banking_application.repositories.AccountRepository;
import com.bny.banking_application.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        account = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }
    
}