package com.hashmi.bankingapp;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByAccountNumber(UUID accountNumber);
}
