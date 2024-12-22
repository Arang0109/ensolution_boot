package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.domain.WorkplaceDto;

import java.util.List;

public interface WorkplaceService {
  List<WorkplaceDto> findWorkplacesByCompanyId(Integer id);
  List<WorkplaceDto> findAllWorkplaces();
  Integer addNewWorkplace(WorkplaceDto workplaceDto);
  Integer updateWorkplace(WorkplaceDto workplaceDto);
  Integer removeWorkplaces(List<WorkplaceDto> workplaces);
}
