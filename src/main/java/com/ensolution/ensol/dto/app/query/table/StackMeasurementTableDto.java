package com.ensolution.ensol.dto.app.query.table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackMeasurementTableDto {
  private Integer stackMeasurementId;
  private Integer stackId;
  private Integer pollutantId;
  private String cycleType;
  private Double allowValue;
  private boolean isCompleted;
  private boolean isMeasured;
  private String pollutantNameKR;
  private String pollutantNameEN;
  private String method;
}
