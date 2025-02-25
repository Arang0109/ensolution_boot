package com.ensolution.ensol.dto.entity.stack;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackInformationDto {
  private Integer stackId;
  private Double diameter;
  private Double dynamicPressure;
  private Double staticPressure;
  private Double velocity;
  private Double quantity;
  private Double temperature;
}
