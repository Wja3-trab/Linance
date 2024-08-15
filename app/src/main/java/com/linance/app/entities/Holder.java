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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private HolderType type;

    // Default constructor
    public Holder() {}

    // Parameterized constructor
    public Holder(User user, Account account, HolderType type) {
        this.user = user;
        this.account = account;
        this.type = type;
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public HolderType getType() {
        return type;
    }

    public void setType(HolderType type) {
        this.type = type;
    }
}
