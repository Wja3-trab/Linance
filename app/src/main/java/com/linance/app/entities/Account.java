package com.linance.app.entities;

import com.linance.app.enumerators.AccountStatus;
import com.linance.app.enumerators.AccountType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int accountId;
    @Column(name = "accountnumber")
    private String accountNumber;
    @Column(name = "type")
    private AccountType type;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "status")
    private AccountStatus status;

    public Account() {
    }

    public Account(String accountNumber, AccountType type, LocalDateTime createDate, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.createDate = createDate;
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
