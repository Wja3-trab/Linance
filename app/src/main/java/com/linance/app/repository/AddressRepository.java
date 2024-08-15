package com.linance.app.repository;

import com.linance.app.entities.Address;
import com.linance.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByUser(User user);
}
