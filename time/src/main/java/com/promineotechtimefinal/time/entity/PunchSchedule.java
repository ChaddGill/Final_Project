package com.promineotechtimefinal.time.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PunchSchedule {
  private Schedule scheduleID;
  private Punch punchID;
  
}
