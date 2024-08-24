package com.linance.app.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressNotFoundException extends ResponseStatusException {
    public AddressNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public static AddressNotFoundException of(String userName) {
        return new AddressNotFoundException(HttpStatus.BAD_REQUEST, "Address not found for the following user:\t" + userName);
    }
}
