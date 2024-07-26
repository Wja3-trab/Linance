package com.linance.app.entities;

import com.linance.app.enumerators.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int transactionId;
    @ManyToOne
    @JoinColumn(name = "accountid", nullable = false)
    private Account accountId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "type")
    private TransactionType transactionType;
    @Column(name = "transactiondate")
    private LocalDateTime transactionDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "recurringtransactionid")
    private RecurringTransaction recurringTransaction;

    public Transaction() {
    }

    public Transaction(Account accountId, double amount, TransactionType transactionType, LocalDateTime transactionDate, String description, RecurringTransaction recurringTransaction) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.description = description;
        this.recurringTransaction = recurringTransaction;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecurringTransaction getRecurringTransaction() {
        return recurringTransaction;
    }

    public void setRecurringTransaction(RecurringTransaction recurringTransaction) {
        this.recurringTransaction = recurringTransaction;
    }
}
