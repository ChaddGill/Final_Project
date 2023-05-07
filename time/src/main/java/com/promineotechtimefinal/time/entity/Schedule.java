package com.promineotechtimefinal.time.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Schedule {
  
  private Long scheduleID;
  private Long employeeID;
  private LocalDateTime clockDateTime;
 // private LocalTime clockTime;
  private PunchChoice punch;
  
  
  @JsonIgnore
  public Long getScheduleID() {
    return scheduleID;
  }
}