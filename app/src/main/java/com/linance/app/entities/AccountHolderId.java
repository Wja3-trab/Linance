package com.linance.app.entities;

import java.io.Serializable;
import java.util.Objects;

public class AccountHolderId implements Serializable {
    private Long user;
    private Long account;

    // Default constructor
    public AccountHolderId() {
    }

    // Parameterized constructor
    public AccountHolderId(Long user, Long account) {
        this.user = user;
        this.account = account;
    }

    // Getters and setters
    public Long getuser() {
        return user;
    }

    public void setuser(Long user) {
        this.user = user;
    }

    public Long getaccount() {
        return account;
    }

    public void setaccount(Long account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolderId that = (AccountHolderId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, account);
    }
}
