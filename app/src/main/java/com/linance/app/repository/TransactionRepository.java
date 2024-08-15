package com.linance.app.repository;

import com.linance.app.entities.Account;
import com.linance.app.entities.RecurringTransaction;
import com.linance.app.entities.Transaction;
import com.linance.app.enumerators.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccountId(Account account);

    List<Transaction> findByRecurringTransaction(RecurringTransaction recurringTransaction);
    List<Transaction> findByTransactionType(TransactionType transactionType);
    List<Transaction> findByTransactionDate(LocalDateTime transactionDate);
    List<Transaction> findByAmount(double amount);
}
