package com.gmail.iikaliada.security;

public interface BruteForceProtectionService {

    void registerLoginFailure(String userName);

    void resetBruteForceCounter(String userName);

    void isBruteForceAttack(String userName);

}
