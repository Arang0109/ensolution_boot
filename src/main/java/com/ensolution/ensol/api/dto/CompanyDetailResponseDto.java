package com.ensolution.ensol.api.dto;

import com.ensolution.ensol.dto.app.entity.company.CompanyDto;
import com.ensolution.ensol.dto.app.entity.company.WorkplaceDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDetailResponseDto {
  private CompanyDto company;
  private List<WorkplaceDto> workplaces;
}
