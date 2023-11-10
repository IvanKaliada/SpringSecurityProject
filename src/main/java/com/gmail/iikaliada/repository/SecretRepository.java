package com.gmail.iikaliada.repository;

import com.gmail.iikaliada.entity.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long> {

    Secret findByUniqueLink(String link);

}
