package com.siddharth.FitTrack.repository;

import com.siddharth.FitTrack.model.ActivityRecordBase;
import com.siddharth.FitTrack.model.ActivityRecordHourly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRecordHourlyRepository extends JpaRepository<ActivityRecordHourly, Long> {

}
