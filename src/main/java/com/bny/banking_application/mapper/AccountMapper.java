package com.bny.banking_application.mapper;

import com.bny.banking_application.dto.AccountDto;
import com.bny.banking_application.entities.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalnce());
    }
}
