package com.ensolution.ensol.dto.app.entity.company;

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
