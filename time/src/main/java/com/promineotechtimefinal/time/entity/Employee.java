package com.promineotechtimefinal.time.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Employee{

  private Long employeeId;
  private String name;
  private Double minHours;
  private Double vacationHours;
  private boolean otEligible;
  

    @JsonIgnore
  public Long getemployeeId() {
    return employeeId;
  }
}
