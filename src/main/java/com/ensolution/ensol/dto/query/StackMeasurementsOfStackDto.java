package com.ensolution.ensol.dto.query;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackMeasurementsOfStackDto {
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
