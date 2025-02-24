package com.ensolution.ensol.management.service;

import com.ensolution.ensol.common.data.dto.WorkplaceDto;

import java.util.List;
import java.util.Optional;

public interface WorkplaceService {
  Optional<WorkplaceDto> findWorkplaceById(Integer id);
  List<WorkplaceDto> findWorkplacesByCompanyId(Integer id);
  List<WorkplaceDto> findAllWorkplaces();
  Integer findFactoryId(Integer id);
  void createWorkplace(WorkplaceDto workplaceDto);
  void updateWorkplace(WorkplaceDto workplaceDto);
  void removeWorkplaces(List<WorkplaceDto> workplaces);
}
