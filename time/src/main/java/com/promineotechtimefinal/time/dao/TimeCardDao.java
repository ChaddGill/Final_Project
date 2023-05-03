package com.promineotechtimefinal.time.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.promineotechtimefinal.time.entity.Employee;
import com.promineotechtimefinal.time.entity.Punch;
import com.promineotechtimefinal.time.entity.Schedule;

public interface TimeCardDao {

  Schedule saveSchedule(Employee employee, LocalDate clockDate, LocalTime clockTime);
  
  Punch fetchpunch(Punch punch);
  
  void fetchTimes(Employee employee, List<Schedule> Schedule,LocalDate ppDate);
  
  void savePunch(List<Punch> punchChoices, Long scheduleID);

}