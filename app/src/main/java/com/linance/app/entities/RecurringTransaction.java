package com.linance.app.entities;

import com.linance.app.enumerators.IntervalType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "recurringtransactions")
public class RecurringTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int recurringTransactionId;
    @ManyToOne
    @JoinColumn(name = "accountid", nullable = false)
    private Account account;
    @Column(name = "amount")
    private double amount;
    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "enddate")
    private LocalDate endDate;
    @Column(name = "type")
    private IntervalType intervalType;
    @Column(name = "occurrences")
    private Integer occurrence;
    @Column(name = "nextrundate")
    private LocalDate nextRunDate;
    @Column(name = "lastrundate")
    private LocalDate lastRunDate;
    @ManyToOne
    @JoinColumn(name = "recipient")
    private Recipient recipient;

    public RecurringTransaction() {
    }

    public RecurringTransaction(Account account, double amount, LocalDate startDate, LocalDate endDate, IntervalType intervalType, Integer occurrence, LocalDate nextRunDate, LocalDate lastRunDate, Recipient recipient) {
        this.account = account;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.intervalType = intervalType;
        this.occurrence = occurrence;
        this.nextRunDate = nextRunDate;
        this.lastRunDate = lastRunDate;
        this.recipient = recipient;
    }

    public int getRecurringTransactionId() {
        return recurringTransactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public IntervalType getIntervalType() {
        return intervalType;
    }

    public void setIntervalType(IntervalType intervalType) {
        this.intervalType = intervalType;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Integer occurrence) {
        this.occurrence = occurrence;
    }

    public LocalDate getNextRunDate() {
        return nextRunDate;
    }

    public void setNextRunDate(LocalDate nextRunDate) {
        this.nextRunDate = nextRunDate;
    }

    public LocalDate getLastRunDate() {
        return lastRunDate;
    }

    public void setLastRunDate(LocalDate lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
