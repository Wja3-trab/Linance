package com.linance.app.entities;

import jakarta.persistence.*;

@Entity(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int addressId;
    @OneToOne
    @JoinColumn(name = "userid")
    private User user;
    @Column(name = "street")
    private String streetName;
    @Column(name = "housenumber")
    private int houseNumber;
    @Column(name = "busnumber")
    private String busNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "postalcode")
    private String postalCode;
    @Column(name = "country")
    private String country;

    public Address() {
    }

    public Address(User user, String streetName, int houseNumber, String busNumber, String city, String postalCode, String country) {
        this.user = user;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.busNumber = busNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
