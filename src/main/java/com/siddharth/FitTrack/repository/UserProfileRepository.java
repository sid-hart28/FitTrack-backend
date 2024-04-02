package com.siddharth.FitTrack.repository;

import com.siddharth.FitTrack.model.UserCredentials;
import com.siddharth.FitTrack.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserId(Long userId);
}
