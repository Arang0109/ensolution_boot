package com.ensolution.ensol.dto.app.entity.stack;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackDto {
  private Integer stackId;
  private Integer workplaceId;
  private String stackName;
  private String stackType;
  private char stackSize;
  private String prevention;
  private Long preventionCapacity;
  private Long fuelUsage;
  private String note;
  private LocalDate regDate;
  private StackInformationDto stackInformation;

  private List<StackImageDto> stackImages;
}