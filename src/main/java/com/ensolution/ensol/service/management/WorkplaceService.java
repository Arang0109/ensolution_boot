package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.management.company.DepartmentDto;
import com.ensolution.ensol.domain.management.company.SubFactoryDto;
import com.ensolution.ensol.domain.management.company.WorkplaceDto;

import java.util.List;

public interface WorkplaceService {
  WorkplaceDto findWorkplaceById(Integer id);
  List<WorkplaceDto> findWorkplacesByCompanyId(Integer id);
  List<WorkplaceDto> findAllWorkplaces();
  List<SubFactoryDto> findSubFactoriesByWorkplaceId(Integer id);
  List<DepartmentDto> findDepartmentsByWorkplaceId(Integer id);
  Integer addNewWorkplace(WorkplaceDto workplaceDto);
  Integer updateWorkplace(WorkplaceDto workplaceDto);
  Integer removeWorkplaces(List<WorkplaceDto> workplaces);
}
