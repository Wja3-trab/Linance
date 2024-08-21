package com.linance.app.repositories;

import com.linance.app.entities.Recipient;
import com.linance.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {
    List<Recipient> findByUser(User user);
    Recipient findByRecipientName(String recipientName);
}
