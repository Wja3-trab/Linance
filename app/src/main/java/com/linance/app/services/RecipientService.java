package com.linance.app.services;

import com.linance.app.entities.Recipient;
import com.linance.app.entities.User;
import com.linance.app.repositories.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipientService {
    private final RecipientRepository recipientRepository;

    @Autowired
    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    @Transactional
    public List<Recipient> getAllRecipients(User user) {
        List<Recipient> recipients = new ArrayList<>();
        try {
            recipients.addAll(recipientRepository.findByUser(user));
            if (recipients.isEmpty()) {
                throw TransactionNotFoundException.of("for " + user.getDetailsUser());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return recipients;
    }

    @Transactional
    public Recipient getRecipient(Integer id) {
        try {
            if (recipientRepository.findById(id).isEmpty()) {
                throw TransactionNotFoundException.of("with this Id: " + id);
            }
            return recipientRepository.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
