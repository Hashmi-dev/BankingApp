package com.hashmi.bankingapp;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
public class Transactions {

    public enum TransactionType {
        INCOMING,
        OUTGOING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    Date timestamp;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

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
