package com.siddharth.FitTrack.repository;

import com.siddharth.FitTrack.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long>{
    Boolean existsByEmail(String email);

    Optional<UserCredentials> findByEmailIgnoreCase(String email);
}
