package com.bny.banking_application.mapper;

import com.bny.banking_application.dto.AccountDto;
import com.bny.banking_application.entities.Account;

//Account Mapper class is used for convert dto to enttity and entity to dto

public class AccountMapper {

    // convert Dto to entity
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
    }

    // convert entity to dto
    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
    }
}
