package com.ensolution.ensol.management.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FactoryDto {
  private Integer factoryId;
  private Integer workplaceId;
  private Integer departmentId;
  private String factoryName;
  private String factoryCategory;
}
