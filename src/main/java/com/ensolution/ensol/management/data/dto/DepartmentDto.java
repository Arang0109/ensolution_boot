package com.ensolution.ensol.management.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDto {
  private Integer departmentId;
  private Integer workplaceId;
  private String departmentName;
  private String departmentPhone;
}
