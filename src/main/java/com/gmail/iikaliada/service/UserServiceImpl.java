package com.gmail.iikaliada.service;

import com.gmail.iikaliada.entity.Authority;
import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void createNewUser(User user) {
        user.setEnabled(Boolean.TRUE);
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        Authority authority = new Authority();
        authority.setAuthority("STANDARD");
        user.setAuthorities(List.of(authority));
        userRepository.save(user);
    }

    @Override
    public List<User> findBlockedUsers() {
        return userRepository.findByEnabled(false);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
