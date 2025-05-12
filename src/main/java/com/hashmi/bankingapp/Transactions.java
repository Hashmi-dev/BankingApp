package com.hashmi.bankingapp;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

// Transaction table made using @entity
@Entity
public class Transactions {

    // The table has an ENUM for the two way money goes
    // it comes in or it goes out
    // still need to figure out what enum is and how it would make
    // an integer or into a format i could read
    public enum TransactionType {
        INCOMING,
        OUTGOING
    }

    // ids are auto generated as usual
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    // dont exactly know why i am supposed to be doing this so i will dig into it
    @Temporal(TemporalType.TIMESTAMP)
    Date timestamp;

    // made it string so it can read
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    // again no clue need to do more digging
    @Column(precision = 19, scale = 4)
    BigDecimal amount;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Transactions() {}

    public Transactions(BigDecimal amount, TransactionType type, Time timestamp) {
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transactions [" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", type=" + type +
                ", amount=" + amount +
                ", account=" + account +
                ']';
    }

    public Long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }
}
