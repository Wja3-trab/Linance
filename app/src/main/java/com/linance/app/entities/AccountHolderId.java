package com.linance.app.entities;

import java.io.Serializable;
import java.util.Objects;

public class AccountHolderId implements Serializable {
    private Long userId;
    private Long accountId;

    // Default constructor
    public AccountHolderId() {
    }

    // Parameterized constructor
    public AccountHolderId(Long userId, Long accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolderId that = (AccountHolderId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountId);
    }
}
