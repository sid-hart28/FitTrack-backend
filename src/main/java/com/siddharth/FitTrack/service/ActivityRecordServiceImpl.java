package com.siddharth.FitTrack.service;

import com.siddharth.FitTrack.model.ActivityRecordHourly;
import com.siddharth.FitTrack.repository.ActivityRecordHourlyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRecordServiceImpl implements ActivityRecordService{

    private final ActivityRecordHourlyRepository activityRecordHourlyRepository;

    @Autowired
    public ActivityRecordServiceImpl(ActivityRecordHourlyRepository activityRecordHourlyRepository) {
        this.activityRecordHourlyRepository = activityRecordHourlyRepository;
    }

    @Override
    @Transactional
    public Boolean addActivityRecordHourly(ActivityRecordHourly activityRecordHourly) {
        try {
            activityRecordHourlyRepository.save(activityRecordHourly);
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

}
