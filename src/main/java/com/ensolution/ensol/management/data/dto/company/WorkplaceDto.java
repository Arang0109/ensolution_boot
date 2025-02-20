package com.ensolution.ensol.management.data.dto.company;

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