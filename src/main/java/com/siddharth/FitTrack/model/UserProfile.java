package com.siddharth.FitTrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class UserProfile {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
//    @Column(name = "id", nullable = false)
    private Long userId;
    @NotNull
//    @Column(name = "name", nullable = false)
    private String name;
    private String dob;
    private Float weight;
    private Float height;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTimestamp;
//    @OneToOne
//    @JoinColumn(name = "user_id") // Reference the ID as a foreign key
//    @MapsId // Use the same ID as the referenced entity (UserCredentials)
//    private UserCredentials userCredentials;


    public UserProfile() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

//    public UserCredentials getUserCredentials() {
//        return userCredentials;
//    }
//
//    public void setUserCredentials(UserCredentials userCredentials) {
//        this.userCredentials = userCredentials;
//    }
}
