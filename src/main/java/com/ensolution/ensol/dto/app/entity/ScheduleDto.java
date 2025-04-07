package com.ensolution.ensol.dto.app.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleDto {
  private Integer scheduleId;
  private Integer stackMeasurementId;
  private Integer teamId;
  private LocalDate measureDate;
  private boolean isCompleted;
  private LocalDate regDate;
}
