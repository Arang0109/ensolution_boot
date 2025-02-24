package com.ensolution.ensol.common.data.dto.stack;

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
