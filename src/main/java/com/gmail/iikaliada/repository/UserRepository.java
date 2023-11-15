package com.gmail.iikaliada.repository;

import com.gmail.iikaliada.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    List<User> findByEnabled(boolean enabled);

}
