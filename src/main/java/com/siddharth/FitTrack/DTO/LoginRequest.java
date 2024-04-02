package com.siddharth.FitTrack.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginRequest {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotNull
    @NotBlank
    private String password;

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
