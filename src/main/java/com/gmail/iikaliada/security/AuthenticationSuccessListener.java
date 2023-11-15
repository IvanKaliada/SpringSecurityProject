package com.gmail.iikaliada.security;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessListener.class);

    private final BruteForceProtectionService service;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String userName = event.getAuthentication().getName();
        LOGGER.info("Login Successful for user {}", userName);
        service.resetBruteForceCounter(userName);
    }

}
