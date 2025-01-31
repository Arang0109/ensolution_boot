package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.company.DepartmentDto;
import com.ensolution.ensol.management.domain.company.SubFactoryDto;
import com.ensolution.ensol.management.domain.company.WorkplaceDto;

import java.util.List;

public interface WorkplaceService {
  WorkplaceDto findWorkplaceById(Integer id);
  List<WorkplaceDto> findWorkplacesByCompanyId(Integer id);
  List<WorkplaceDto> findAllWorkplaces();
  List<SubFactoryDto> findSubFactoriesByWorkplaceId(Integer id);
  List<DepartmentDto> findDepartmentsByWorkplaceId(Integer id);
  void createWorkplace(WorkplaceDto workplaceDto);
  void updateWorkplace(WorkplaceDto workplaceDto);
  void removeWorkplaces(List<WorkplaceDto> workplaces);
}
