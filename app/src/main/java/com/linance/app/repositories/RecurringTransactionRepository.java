package com.linance.app.repositories;

import com.linance.app.entities.Account;
import com.linance.app.entities.RecurringTransaction;
import com.linance.app.enumerators.IntervalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface RecurringTransactionRepository extends JpaRepository<RecurringTransaction, Integer> {
    List<RecurringTransaction> findByAccount(Account account);
    List<RecurringTransaction> findByStartDate(LocalDate startDate);
    List<RecurringTransaction> findByEndDate(LocalDate endDate);
    List<RecurringTransaction> findByIntervalType(IntervalType intervalType);
    List<RecurringTransaction> findByOccurrence(int occurrences);
    List<RecurringTransaction> findByNextRunDate(LocalDate nextRunDate);
    List<RecurringTransaction> findByLastRunDate(LocalDate nextRunDate);
}
