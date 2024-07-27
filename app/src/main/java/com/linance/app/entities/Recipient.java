package com.linance.app.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "recipients")
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int recipientId;
    @ManyToOne
    @JoinColumn(name = "startdate")
    private User user;
    @Column(name = "recipientname")
    private String recipientName;
    public Recipient(){}
    public Recipient(User user, String recipientName) {
        this.user = user;
        this.recipientName = recipientName;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}
