//package com.siddharth.FitTrack.model;
//
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//import java.util.List;
//
//@Entity
//public class UserHealthData {
//    @Id
//    private Long userId;
//
//    private ActivityRecordBase totalStepCount;
//
//    private ActivityRecordBase absoluteStepCount;
//
//    private ActivityRecordBase totalWalkingTime;
//
//    @ElementCollection
//    private List<ActivityRecordBase> hourlyStepCounts;
//
//    @ElementCollection
//    private List<Long> dailyStepCounts;
//
//    @ElementCollection
//    private List<Long> hourlyTimeCounts;
//
//    @ElementCollection
//    private List<Long> dailyTimeCounts;
//
//    public UserHealthData() {
//    }
//
//}
