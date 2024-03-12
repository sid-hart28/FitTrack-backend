package com.siddharth.FitTrack.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


/*
    For encryption of password.
*/

@Service
public class EncryptionService {

    @Value("${encryption.salt.rounds:10}")
    private int saltRounds;

    private String salt;

    @PostConstruct
    public void postconstruct()
    {
        salt= BCrypt.gensalt(saltRounds);
    }

    public String encryptPassword(String password)
    {
        return BCrypt.hashpw(password,salt);
    }

    public boolean verifyPassword(String password,String hash)
    {
        return BCrypt.checkpw(password, hash);
    }
}
