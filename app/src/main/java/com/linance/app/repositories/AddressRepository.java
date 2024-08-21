package com.linance.app.repositories;

import com.linance.app.entities.Address;
import com.linance.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByUser(User user);
}
