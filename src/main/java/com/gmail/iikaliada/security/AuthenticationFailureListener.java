package com.gmail.iikaliada.security;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessListener.class);

    private final BruteForceProtectionService service;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String userName = event.getAuthentication().getName();
        LOGGER.warn("User {} has failed password attempt", userName);
        service.registerLoginFailure(userName);
    }

}
