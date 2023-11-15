package com.gmail.iikaliada.service;

import com.gmail.iikaliada.entity.Authority;
import com.gmail.iikaliada.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service("customUserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Value("${time.interval}")
    private int timeInterval;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        if (isDateTimeLaterByMinutes(user.getLastTimeFailed(), timeInterval)) {
            user.setEnabled(true);
            userService.saveUser(user);
        }
        boolean userDisabled = !user.isEnabled();
        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword())
                .username(user.getUserName())
                .disabled(userDisabled)
                .authorities(user.getAuthorities().stream().map(Authority::getAuthority
                ).toArray(String[]::new)).build();
    }

    public boolean isDateTimeLaterByMinutes(LocalDateTime lastTimeAttempt, int minutes) {
        if (lastTimeAttempt == null) {
            return false;
        }
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime modifiedDateTime = lastTimeAttempt.plus(minutes, ChronoUnit.MINUTES);
        return modifiedDateTime.isAfter(currentTime);
    }

}
