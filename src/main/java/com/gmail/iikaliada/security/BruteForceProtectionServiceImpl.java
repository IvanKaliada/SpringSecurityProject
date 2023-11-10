package com.gmail.iikaliada.security;

import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BruteForceProtectionServiceImpl implements BruteForceProtectionService {

    @Value("${brute.force.failedlogin.count}")
    private int maxFailedLogin;

    private final UserService userService;

    @Override
    public void registerLoginFailure(String userName) {
        User user = userService.findUserByUserName(userName);
        if (user != null && user.isEnabled()) {
            int failedCounter = user.getFailedLoginAttempt();
            if (maxFailedLogin < failedCounter + 1) {
                user.setEnabled(false);
            } else {
                user.setFailedLoginAttempt(failedCounter + 1);
            }
            user.setLastTimeFailed(LocalDateTime.now());
            userService.saveUser(user);
        }
    }

    @Override
    public void resetBruteForceCounter(String userName) {
        User user = userService.findUserByUserName(userName);
        if (user != null) {
            user.setFailedLoginAttempt(0);
            user.setEnabled(true);
            userService.saveUser(user);
        }
    }

    @Override
    public void isBruteForceAttack(String userName) {
    }

}
