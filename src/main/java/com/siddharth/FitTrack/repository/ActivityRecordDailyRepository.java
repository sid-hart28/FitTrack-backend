package com.siddharth.FitTrack.repository;

import com.siddharth.FitTrack.model.ActivityRecordDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRecordDailyRepository extends JpaRepository<ActivityRecordDaily, Long> {

}
