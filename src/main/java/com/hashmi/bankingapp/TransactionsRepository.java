package com.hashmi.bankingapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions, Long> {
    List<Transactions> findByAccountAccountId(Long accountId);
    List<Transactions> findByType(Transactions.TransactionType type);
}

