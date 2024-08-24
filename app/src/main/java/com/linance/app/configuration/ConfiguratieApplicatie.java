package com.linance.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.SecureRandom;

@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class ConfiguratieApplicatie implements WebMvcConfigurer {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }
}
