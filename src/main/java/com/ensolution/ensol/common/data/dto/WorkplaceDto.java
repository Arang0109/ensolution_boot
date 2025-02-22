package com.ensolution.ensol.common.data.dto;

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
  private String address;
  private boolean existFactory;
  private LocalDate regDate;
}