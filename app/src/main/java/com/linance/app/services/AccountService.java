package com.linance.app.services;

import com.linance.app.entities.Account;
import com.linance.app.enumerators.AccountStatus;
import com.linance.app.enumerators.AccountType;
import com.linance.app.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account getAccount(String accountNumber) {
        try {
            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                throw new RuntimeException("No such account exists with the following number:\t" + accountNumber);
            }
            return account;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Transactional
    public void createAccount(String accountNumber, AccountType type, LocalDateTime createDate, AccountStatus status) {
        try {
            if (accountRepository.findByAccountNumber(accountNumber) != null) {
                throw AccountNumberTakenException.of(accountNumber);
            }
            Account account = new Account(accountNumber, type, createDate, status);
            accountRepository.save(account);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Transactional
    public void closeAccount(String accountNumber) {
        try {
            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account != null) {
                account.setStatus(AccountStatus.CLOSED);
                System.out.println("Account " + accountNumber + " got closed");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Transactional
    public void openAccount(String accountNumber) {
        try {
            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account != null) {
                account.setStatus(AccountStatus.ACTIVE);
                System.out.println("Account " + accountNumber + " got activated");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
