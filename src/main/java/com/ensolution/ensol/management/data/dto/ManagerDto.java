package com.ensolution.ensol.management.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ManagerDto {
  private Integer managerId;
  private Integer factoryId;
  private String managerName;
  private String managerPhone;
  private String managerPosition;
}
