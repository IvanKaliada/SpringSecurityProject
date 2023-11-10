package com.gmail.iikaliada.service;

import com.gmail.iikaliada.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findUsers();

    User findUserByUserName(String userName);

    void createNewUser(User user);

    List<User> findBlockedUsers();

}
