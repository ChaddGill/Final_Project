package com.promineotechtimefinal.time.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotechtimefinal.time.dao.TimeCardDao;
import com.promineotechtimefinal.time.entity.Employee;
import com.promineotechtimefinal.time.entity.Punch;
import com.promineotechtimefinal.time.entity.Schedule;

@Service
public class DefaultTimeCardService implements TimeCardService {

  @Autowired
  private TimeCardDao timeCardDao;

  @Transactional
  @Override
  public Schedule saveSchedule(Employee employee, LocalDate clockDate,
      LocalTime clockTime) {


    return timeCardDao.saveSchedule(employee, clockDate, clockTime);
  }

  @Override
  public void savePunch(List<Punch> punchChoices, Long scheduleID) {
    timeCardDao.savePunch(punchChoices, scheduleID);
    
  };

  @Override
  public Punch fetchpunch(Punch punch) {
    
    return timeCardDao.fetchpunch(punch);
  }

  @Override
  public void fetchTimes(Employee employee, List<Schedule> Schedule, LocalDate ppDate) {
    timeCardDao.fetchTimes(employee, Schedule, ppDate);

  }


}