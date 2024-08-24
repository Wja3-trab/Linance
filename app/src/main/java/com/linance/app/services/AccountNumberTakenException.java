package com.linance.app.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class AccountNumberTakenException extends ResponseStatusException {
    public AccountNumberTakenException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public static AccountNumberTakenException of(String accountNumber) {
        return new AccountNumberTakenException(HttpStatus.BAD_REQUEST, "'" + accountNumber + "' is already taken");
    }
}
