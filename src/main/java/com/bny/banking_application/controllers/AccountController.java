package com.bny.banking_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bny.banking_application.dto.AccountDto;
import com.bny.banking_application.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accService;

    public AccountController(AccountService accService) {
        this.accService = accService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto accDto = accService.createAccount(accountDto);
        return ResponseEntity.ok(accDto);
    }
}
