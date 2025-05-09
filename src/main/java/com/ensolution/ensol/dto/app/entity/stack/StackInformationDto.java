package com.ensolution.ensol.dto.app.entity.stack;

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
  private Integer gasTemperature;
  private Double quantity;
  private Double height;
  private String stackShape;
}
