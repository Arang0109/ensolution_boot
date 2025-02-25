package com.ensolution.ensol.dto.query.table;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleTableDto {
  private String scheduleIds;
  private Integer teamId;
  private String stackMeasurementIds;
  private String workplaceName;
  private String stackName;
  private Integer stackId;
  private String pollutants;
  private String pollutantIds;
  private String teamName;
  private LocalDate measureDate;
  private boolean isCompleted;
}