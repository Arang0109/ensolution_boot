package com.ensolution.ensol.dto.app.entity.company;

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
