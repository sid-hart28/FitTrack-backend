package com.siddharth.FitTrack.DTO;

import com.siddharth.FitTrack.model.UserProfile;

public class LoginResponse {

    private Integer status;
    private String message;
    private UserProfile userProfile;

    public LoginResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
