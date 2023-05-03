package com.promineotechtimefinal.time.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Schedule {
  
  private Long scheduleID;
  private Employee employee;
  private LocalDate clockDate;
  private LocalTime clockTime;
  private List<Punch> punch;

  
  @JsonIgnore
  public Long getScheduleID() {
    return scheduleID;
  }
}