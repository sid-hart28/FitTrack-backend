package com.siddharth.FitTrack.service;

import com.siddharth.FitTrack.DTO.LoginRequest;
import com.siddharth.FitTrack.DTO.LoginResponse;
import com.siddharth.FitTrack.DTO.RegisterRequest;
import com.siddharth.FitTrack.model.UserCredentials;
import com.siddharth.FitTrack.model.UserProfile;
import com.siddharth.FitTrack.repository.UserCredentialsRepository;
import com.siddharth.FitTrack.repository.UserProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;


@Service
public class UserServiceImpl implements UserService {


    private final UserCredentialsRepository userCredentialsRepository;
    private final UserProfileRepository userProfileRepository;
    private final EncryptionService encryptionService;

    @Autowired
    public UserServiceImpl(UserCredentialsRepository userCredentialsRepository,
                           UserProfileRepository userProfileRepository,
                           EncryptionService encryptionService) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.userProfileRepository = userProfileRepository;
        this.encryptionService = encryptionService;
    }

    @Override
    @Transactional
    public LoginResponse addUser(RegisterRequest registerRequest) {
        System.out.println("In UserService(addUser)");
        LoginResponse loginResponse = new LoginResponse();

        if(!userCredentialsRepository.existsByEmail(registerRequest.getEmail())) {
            // Create UserCredentials entity
            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setEmail(registerRequest.getEmail());
            userCredentials.setPassword(encryptionService.encryptPassword(registerRequest.getPassword()));
            userCredentials.setActiveLoginCount(1);
            // Save UserCredentials to the database
            userCredentialsRepository.save(userCredentials);

            // Create UserProfile entity
            UserProfile userProfile = new UserProfile();
            userProfile.setUserId(userCredentials.getUserId());
            userProfile.setName(registerRequest.getName());
            userProfile.setDob(registerRequest.getDob());
            userProfile.setWeight(registerRequest.getWeight());
            userProfile.setHeight(registerRequest.getHeight());
            System.out.println(userCredentials.getEmail());

            // Save UserProfile to the database
            userProfileRepository.save(userProfile);
//            System.out.println(userProfile.getCreationTimestamp());

            loginResponse.setUserProfile(userProfile);
            loginResponse.setStatus(0);
            loginResponse.setMessage("Successful registration");
        }
        else {
            loginResponse.setStatus(1);
            loginResponse.setMessage("Email already exists");
        }

        return loginResponse;
    }

    public LoginResponse loginUser (LoginRequest loginRequest)
    {
        System.out.println("In loginUser");
        LoginResponse loginResponse = new LoginResponse();
        if(userCredentialsRepository.existsByEmail(loginRequest.getEmail()))
        {
            Optional<UserCredentials> optionalUserCredentials = userCredentialsRepository.findByEmailIgnoreCase(loginRequest.getEmail());
            if(optionalUserCredentials.isPresent()) {

                UserCredentials userCredentials = optionalUserCredentials.get();
                if (encryptionService.verifyPassword(loginRequest.getPassword(), userCredentials.getPassword())) {
                    Long userId = userCredentials.getUserId();
                    Optional<UserProfile> optionalUserProfile = userProfileRepository.findByUserId(userId);
                    if (optionalUserProfile.isPresent()) {
                        loginResponse.setUserProfile(optionalUserProfile.get());
                        loginResponse.setStatus(0);
                        loginResponse.setMessage("Successful login");
                    } else {
                        loginResponse.setStatus(1);
                        loginResponse.setMessage("Error fetching profile");
                    }
                }
                else {
                    loginResponse.setStatus(2);
                    loginResponse.setMessage("Password does not match");
                }
            }
        }
        else {
            loginResponse.setStatus(3);
            loginResponse.setMessage("Email does not exists");
        }
        return loginResponse;
    }

}
