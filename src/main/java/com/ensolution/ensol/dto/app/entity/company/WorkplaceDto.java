package com.ensolution.ensol.dto.app.entity.company;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkplaceDto {
  private Integer workplaceId;
  private Integer companyId;
  private String workplaceName;
  private char workplaceSize;
  private String address;
  private String mainProduction;
  private String businessType;
  private LocalDate regDate;
}