package com.promineotechtimefinal.time.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Punch {
  private Long punchID;
  private PunchChoice punchChoice;

}
