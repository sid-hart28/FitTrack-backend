package com.siddharth.FitTrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
//    @Column(name = "id", nullable = false)
    private Long userId;

    @Column(nullable = false, unique = true, length = 320)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 1000)
    private String password;

    private Integer activeLoginCount;

//    @OneToOne(mappedBy = "userCredentials", cascade = CascadeType.ALL)
//    @MapsId // Use the same ID as the parent entity (UserProfile)
//    private UserProfile userProfile;

    public UserCredentials() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getActiveLoginCount() {
        return activeLoginCount;
    }

    public void setActiveLoginCount(Integer activeLoginCount) {
        this.activeLoginCount = activeLoginCount;
    }

    //    public UserProfile getUserProfile() {
//        return userProfile;
//    }
//
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }
}
