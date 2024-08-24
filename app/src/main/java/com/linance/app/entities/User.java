package com.linance.app.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userID;
    @Column(name = "voornaam")
    private String firstname;
    @Column(name = "achternaam")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "passwordhash")
    private String password;
    @Column(name = "createdate")
    private LocalDateTime createDate;

    public User() {

    }

    public User(String firstname, String lastname, String email, String password, LocalDateTime createDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getDetailsUser() {
        return "Id: " + this.getUserID() + ", FullName: " + (this.getFirstname().concat(" " + this.getLastname())) + ", Email: " + this.getEmail();
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
