package com.ensolution.ensol.dto.app.entity.company;

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
