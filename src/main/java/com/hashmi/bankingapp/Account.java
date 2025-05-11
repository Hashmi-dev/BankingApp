package com.hashmi.bankingapp;

import jakarta.persistence.*;

import java.util.UUID;

// @Entity tells the JPA to map the class into table name Account
// Account table will be used to store data about different accounts owned by a user

@Entity
// No need for @Table account is not a reserved word
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long account_id;
    UUID accountNumber;
    Long current_amount;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @OneToMany (mappedBy = "Account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Transactions transactions;

    public Account() {
    }

    public Account(UUID accountNumber, Long current_amount) {
        this.accountNumber = accountNumber;
        this.current_amount = current_amount;
    }

    @Override
    public String toString() {
        return "Account [" +
                "account_id=" + account_id +
                ", accountNumber=" + accountNumber +
                ", current_amount=" + current_amount +
                ", user=" + user +
                ']';
    }

    public Long getAccount_id() {
        return account_id;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public Long getCurrent_amount() {
        return current_amount;
    }

    public User getUser() {
        return user;
    }
}
