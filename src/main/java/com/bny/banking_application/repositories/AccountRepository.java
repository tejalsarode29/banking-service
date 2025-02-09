package com.bny.banking_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bny.banking_application.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
