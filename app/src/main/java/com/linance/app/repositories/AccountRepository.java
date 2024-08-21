package com.linance.app.repositories;

import com.linance.app.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(int id);
    Account findByAccountNumber(String accountnumber);
}
