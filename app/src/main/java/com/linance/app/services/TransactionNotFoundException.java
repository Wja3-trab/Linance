package com.linance.app.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TransactionNotFoundException extends ResponseStatusException {
    public TransactionNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public static TransactionNotFoundException of(String reason) {
        return new TransactionNotFoundException(HttpStatus.BAD_REQUEST, "No transaction(s) found " + reason);
    }
}
