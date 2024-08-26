package com.linance.app.services;

import com.linance.app.entities.Account;
import com.linance.app.entities.Recipient;
import com.linance.app.entities.RecurringTransaction;
import com.linance.app.entities.Transaction;
import com.linance.app.enumerators.TransactionType;
import com.linance.app.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public List<Transaction> getTransactions(Account account) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            transactions = transactionRepository.findByAccountId(account);
            if (transactions.isEmpty()) {
                throw TransactionNotFoundException.of("for " + account.getAccountNumber());
            }
            return transactions;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return transactions;
    }

    @Transactional
    public void createInstantTransaction(Account account, double amount, TransactionType transactionType, LocalDateTime transactionDate, String description, RecurringTransaction recurringTransaction, Recipient recipient) {
        try {
            Transaction transaction = new Transaction();
            transaction.setAccountId(account);
            transaction.setAmount(amount);
            transaction.setTransactionType(transactionType);
            transaction.setTransactionDate(transactionDate);
            transaction.setDescription(description);
            transaction.setRecurringTransaction(recurringTransaction);
            transaction.setRecipient(recipient);
            transactionRepository.save(transaction);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Transactional
    public void deleteTransaction(Integer id) {
        try {
            if (transactionRepository.findById(id).isEmpty()) {
                throw TransactionNotFoundException.of("with the following Id: " + id);
            }
            Transaction transaction = transactionRepository.findById(id).get();
            transactionRepository.delete(transaction);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
