package com.linance.app.repositories;

import com.linance.app.entities.Account;
import com.linance.app.entities.AccountHolderId;
import com.linance.app.entities.Holder;
import com.linance.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HolderRepository extends JpaRepository<Holder, AccountHolderId> {
    List<Holder> findByUser(User user);
    List<Holder> findByAccount(Account account);
}
