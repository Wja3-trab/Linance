package com.linance.app.repositories;

import com.linance.app.entities.Recipient;
import com.linance.app.entities.RecipientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecipientAccountRepository extends JpaRepository<RecipientAccount, Integer> {
    List<RecipientAccount> findByRecipient(Recipient recipient);
    List<RecipientAccount> findByBankName(String bankName);
    Recipient findByAccountNumber(String accountNumber);
}
