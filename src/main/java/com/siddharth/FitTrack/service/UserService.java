package com.siddharth.FitTrack.service;

import com.siddharth.FitTrack.DTO.LoginRequest;
import com.siddharth.FitTrack.DTO.LoginResponse;
import com.siddharth.FitTrack.DTO.RegisterRequest;
import com.siddharth.FitTrack.exception.UserAlreadyExistsException;
import com.siddharth.FitTrack.model.UserProfile;

public interface UserService {
    LoginResponse addUser(RegisterRequest registerRequest);

    LoginResponse loginUser(LoginRequest loginRequest);

}
