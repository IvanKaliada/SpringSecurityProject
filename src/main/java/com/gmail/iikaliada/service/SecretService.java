package com.gmail.iikaliada.service;

import com.gmail.iikaliada.entity.Secret;

public interface SecretService {

    Secret findByUniqueLink(String link);

    Secret saveSecret(Secret secret);

    void deleteSecretById(Long id);

}
