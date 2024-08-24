package com.linance.app.services;

import com.linance.app.entities.User;
import com.linance.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User getUserByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new RuntimeException("User not found!");
            }
            System.out.println(user.getFirstname() + "\n" + user.getLastname());
            return user;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Transactional
    public void saveUser(String voornaam, String achternaam, String email, String password) {
        try {
            User user = new User();
            user.setFirstname(voornaam);
            user.setLastname(achternaam);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
