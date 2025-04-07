package com.ensolution.ensol.dto.app.entity.stack;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackMeasurementDto {
  private Integer stackMeasurementId;
  private Integer stackId;
  private Integer pollutantId;
  private String cycleType;
  private Double allowValue;
  private boolean isCompleted; // 측정 완료 여부 check
  private boolean isMeasured; // 시설 가동 여부 check
}
