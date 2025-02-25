package com.ensolution.ensol.dto.query;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackTableDto {
  private Integer stackId;
  private String stackName;
  private String companyName;
  private String workplaceName;
  private String factoryCategory;
  private String factoryName;
  private String departmentName;
}
