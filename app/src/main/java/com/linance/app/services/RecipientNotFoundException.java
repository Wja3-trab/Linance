package com.linance.app.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RecipientNotFoundException extends ResponseStatusException {
    public RecipientNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    static RecipientNotFoundException of(String userDetails) {
        return new RecipientNotFoundException(HttpStatus.BAD_REQUEST, "No recipient(s) found for user " + userDetails);
    }
}
