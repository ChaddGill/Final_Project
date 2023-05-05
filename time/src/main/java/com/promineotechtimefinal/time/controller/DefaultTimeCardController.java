package com.promineotechtimefinal.time.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotechtimefinal.time.entity.Employee;
import com.promineotechtimefinal.time.entity.Schedule;
import com.promineotechtimefinal.time.service.TimeCardService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultTimeCardController implements TimeCardController {

  @Autowired
  private TimeCardService timeCardService;
  
  @Override
  public Schedule saveSchedule(Long employeeID) {
    log.debug("Employee= {}", employeeID);
//    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    LocalDateTime dateTime = LocalDateTime.parse(clockDateTime, formatDate);
   
    return timeCardService.saveSchedule(employeeID);  
    }
}