package com.promineotechtimefinal.time.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotechtimefinal.time.dao.TimeCardDao;
import com.promineotechtimefinal.time.entity.Punch;
import com.promineotechtimefinal.time.entity.Schedule;

@Service
public class DefaultTimeCardService implements TimeCardService {

  @Autowired
  private TimeCardDao timeCardDao;

  @Transactional
  @Override
  public Schedule saveSchedule(Long employeeID) {
    return timeCardDao.saveSchedule(employeeID);
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
  public void fetchTimes(Long employeeID, List<Schedule> Schedule, LocalDateTime ppDate) {
    timeCardDao.fetchTimes(employeeID, Schedule, ppDate);

  }


}