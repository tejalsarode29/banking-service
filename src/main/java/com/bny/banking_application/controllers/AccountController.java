package com.bny.banking_application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getAccountById/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable(value="id") Long id) {
        AccountDto accountDto = accService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDtos = accService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto accDto = accService.createAccount(accountDto);
        return ResponseEntity.ok(accDto);
    }

    @GetMapping("/deposit/{id}/{amount}")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable(value = "id") Long id, @PathVariable(value = "amount") double amount) {
        return ResponseEntity.ok(accService.deposit(id, amount));
    }
}
