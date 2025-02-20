package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.data.dto.company.WorkplaceDto;

import java.util.List;
import java.util.Optional;

public interface WorkplaceDataService {
  Optional<WorkplaceDto> findWorkplaceById(Integer id);

  List<WorkplaceDto> findWorkplacesByCompanyId(Integer companyId);

  List<WorkplaceDto> findAll();

  void saveWorkplace(WorkplaceDto workplaceDto);

  void deleteWorkplaces(List<Integer> ids);

  boolean existsById(Integer id);
}
