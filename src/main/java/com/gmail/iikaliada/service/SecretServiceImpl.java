package com.gmail.iikaliada.service;

import com.gmail.iikaliada.entity.Secret;
import com.gmail.iikaliada.repository.SecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecretServiceImpl implements SecretService {

    private final SecretRepository secretRepository;

    @Override
    public Secret findByUniqueLink(String link) {
        return secretRepository.findByUniqueLink(link);
    }

    @Override
    public Secret saveSecret(Secret secret) {
        String uniqueLink = UUID.randomUUID().toString();
        secret.setUniqueLink(uniqueLink);
        return secretRepository.save(secret);
    }

    @Override
    public void deleteSecretById(Long id) {
        secretRepository.deleteById(id);
    }

}
