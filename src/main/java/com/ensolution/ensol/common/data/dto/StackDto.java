package com.ensolution.ensol.common.data.dto;

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
  private Integer factoryId;
  private String stackName;
  private String prevention;
  private String note;
  private LocalDate regDate;
  private StackInformationDto stackInformation;

  private List<StackImageDto> stackImages;
}