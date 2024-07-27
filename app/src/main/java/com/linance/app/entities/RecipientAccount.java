package com.linance.app.entities;

import jakarta.persistence.*;


@Entity(name = "recipientaccounts")
public class RecipientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int recipientAccountId;
    @ManyToOne
    @JoinColumn(name = "recipientid")
    private Recipient recipient;
    @Column(name = "accountnumber")
    private String accountNumber;
    @Column(name = "bankname")
    private String bankName;

    public RecipientAccount() {
    }

    public RecipientAccount(Recipient recipient, String accountNumber, String bankName) {
        this.recipient = recipient;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    public int getRecipientAccountId() {
        return recipientAccountId;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
