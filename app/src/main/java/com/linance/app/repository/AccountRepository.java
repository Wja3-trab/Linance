package com.linance.app.repository;

import com.linance.app.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(int id);
    Account findByAccountNumber(String accountnumber);
}
