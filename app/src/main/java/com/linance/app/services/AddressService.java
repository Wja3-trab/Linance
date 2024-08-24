package com.linance.app.services;

import com.linance.app.entities.Address;
import com.linance.app.entities.User;
import com.linance.app.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address getAddress(User user) {
        try {
            Address address = addressRepository.findByUser(user);
            if (address == null) {
                throw AddressNotFoundException.of(user.getLastname());
            }
            return address;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Transactional
    public void createAddress(User user, String streetName, int houseNumber, String busNumber, String city, String postalCode, String country) {
        try {
            Address address = new Address();
            address.setUser(user);
            address.setStreetName(streetName);
            address.setHouseNumber(houseNumber);
            address.setBusNumber(busNumber);
            address.setCity(city);
            address.setPostalCode(postalCode);
            address.setCountry(country);
            addressRepository.save(address);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Transactional
    public void updateAddress(User user, String streetName, int houseNumber, String busNumber, String city, String postalCode, String country) {
        try {
            if (addressRepository.findByUser(user) == null) {
                throw AddressNotFoundException.of(user.getDetailsUser());
            }
            Address address = addressRepository.findByUser(user);
            address.setUser(user);
            address.setStreetName(streetName);
            address.setHouseNumber(houseNumber);
            address.setBusNumber(busNumber);
            address.setCity(city);
            address.setPostalCode(postalCode);
            address.setCountry(country);
            addressRepository.save(address);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
