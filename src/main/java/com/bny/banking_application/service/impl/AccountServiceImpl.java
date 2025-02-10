package com.bny.banking_application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> lstOfAccDto = new ArrayList<>();
        for (Account account : accounts) {
            lstOfAccDto.add(AccountMapper.mapToAccountDto(account));
        }
        return lstOfAccDto;
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Optional<Account> account = accountRepository.findById(id);
        Account updatedAccount = null;
        if (!account.isEmpty() && account.get().getBalance() >= 0) {
            double newBalance = account.get().getBalance() + amount;
            account.get().setBalance(newBalance);
            updatedAccount = accountRepository.save(account.get());
        }
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance ");
        }

        double totalAmount = account.getBalance() - amount; // suppose we have 10000 balace and ammont is 5000 then
                                                            // 10000-5000
        account.setBalance(totalAmount); // set the new balace in database i.e 5000

        Account savedAccount = accountRepository.save(account); // set balance
        return AccountMapper.mapToAccountDto(savedAccount); // convert it into dto.
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit"));
        accountRepository.delete(account);
    }

}