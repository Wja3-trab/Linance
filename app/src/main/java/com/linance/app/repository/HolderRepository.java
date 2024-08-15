package com.linance.app.repository;

import com.linance.app.entities.Account;
import com.linance.app.entities.AccountHolderId;
import com.linance.app.entities.Holder;
import com.linance.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolderRepository extends JpaRepository<Holder, AccountHolderId> {
    List<Holder> findByUser(User user);
    List<Holder> findByAccount(Account account);
}
