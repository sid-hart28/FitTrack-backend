package com.siddharth.FitTrack.controller;

import com.siddharth.FitTrack.model.ActivityRecordHourly;
import com.siddharth.FitTrack.service.ActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityRecordController {

    @Autowired
    private ActivityRecordService activityRecordService;

    @PostMapping("/addHourly")
    public ResponseEntity<Boolean> addActivityRecordHourly(@RequestBody ActivityRecordHourly activityRecordHourly) {
        try{
        Boolean isSaved = activityRecordService.addActivityRecordHourly(activityRecordHourly);
        return ResponseEntity.ok(isSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
