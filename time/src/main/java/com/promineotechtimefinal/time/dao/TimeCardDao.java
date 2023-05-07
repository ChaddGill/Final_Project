package com.promineotechtimefinal.time.dao;

import java.time.LocalDateTime;
import java.util.List;
import com.promineotechtimefinal.time.entity.Punch;
import com.promineotechtimefinal.time.entity.Schedule;

public interface TimeCardDao {

  Schedule saveSchedule(Long employeeID);
  
  Punch fetchpunch(Punch punch);
  
  void fetchTimes(Long employeeID, List<Schedule> Schedule,LocalDateTime ppDate);
  
  void savePunch(List<Punch> punchChoices, Long scheduleID);

}