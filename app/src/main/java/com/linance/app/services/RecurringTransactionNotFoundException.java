package com.linance.app.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecurringTransactionNotFoundException extends ResponseStatusException {
    public RecurringTransactionNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public static RecurringTransactionNotFoundException of(String accountNumber) {
        return new RecurringTransactionNotFoundException(HttpStatus.BAD_REQUEST, "No recurring transactions found for accountnumber -> " + accountNumber);
    }
}
