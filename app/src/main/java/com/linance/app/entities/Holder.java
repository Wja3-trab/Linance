package com.linance.app.entities;

import com.linance.app.enumerators.HolderType;
import jakarta.persistence.*;

@Entity(name = "accountholders")
@IdClass(AccountHolderId.class)
public class Holder {
    @Id
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    private Account account;
    @Column(name = "type")
    private HolderType type;

    public Holder() {
    }

    public Holder(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userID) {
        this.user = userID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountID) {
        this.account = accountID;
    }

    public HolderType getType() {
        return type;
    }

    public void setType(HolderType type) {
        this.type = type;
    }
}
