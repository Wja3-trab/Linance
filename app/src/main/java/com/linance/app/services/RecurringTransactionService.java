package com.linance.app.services;

import com.linance.app.entities.Account;
import com.linance.app.entities.RecurringTransaction;
import com.linance.app.enumerators.IntervalType;
import com.linance.app.repositories.RecurringTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecurringTransactionService {
    private final RecurringTransactionRepository recurringTransactionRepository;

    @Autowired
    public RecurringTransactionService(RecurringTransactionRepository recurringTransactionRepository) {
        this.recurringTransactionRepository = recurringTransactionRepository;
    }

    @Transactional
    public List<RecurringTransaction> getRecurringTransactions(Account account) {
        List<RecurringTransaction> recurringTransactions = new ArrayList<>();
        try {
            recurringTransactions.addAll(recurringTransactionRepository.findByAccount(account));
            if (recurringTransactions.isEmpty()) {
                throw RecurringTransactionNotFoundException.of(account.getAccountNumber());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return recurringTransactions;
    }

    @Transactional
    public void createRecurringTransaction(Account account, double amount, LocalDate startDate, LocalDate endDate, IntervalType intervalType, Integer occurrence, LocalDate nextRunDate, LocalDate lastRunDate) {
        try {
            RecurringTransaction recurringTransaction = new RecurringTransaction();
            recurringTransaction.setAccount(account);
            recurringTransaction.setAmount(amount);
            recurringTransaction.setStartDate(startDate);
            recurringTransaction.setEndDate(endDate);
            recurringTransaction.setIntervalType(intervalType);
            recurringTransaction.setOccurrence(occurrence);
            recurringTransaction.setNextRunDate(nextRunDate);
            recurringTransaction.setLastRunDate(lastRunDate);
            recurringTransactionRepository.save(recurringTransaction);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Transactional
    public void deleteRecurringTransaction(RecurringTransaction recurringTransaction) {
        try {
            if (!recurringTransactionRepository.existsById(recurringTransaction.getRecurringTransactionId())) {
                throw RecurringTransactionNotFoundException.of(recurringTransaction.getAccount().getAccountNumber());
            }
            recurringTransactionRepository.delete(recurringTransaction);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
