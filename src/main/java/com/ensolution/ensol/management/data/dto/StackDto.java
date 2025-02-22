package com.ensolution.ensol.management.data.dto;

import lombok.*;

import java.time.LocalDate;

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
}