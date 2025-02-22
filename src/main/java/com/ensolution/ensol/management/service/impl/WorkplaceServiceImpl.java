package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.data.dto.WorkplaceDto;
import com.ensolution.ensol.management.service.WorkplaceDataService;
import com.ensolution.ensol.management.service.WorkplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkplaceServiceImpl implements WorkplaceService {
  private final WorkplaceDataService workplaceDataService;

  @Override
  public Optional<WorkplaceDto> findWorkplaceById(Integer id) {
    return workplaceDataService.findWorkplaceById(id);
  }

  @Override
  public List<WorkplaceDto> findWorkplacesByCompanyId(Integer companyId) {
    return workplaceDataService.findWorkplacesByCompanyId(companyId);
  }

  @Override
  public List<WorkplaceDto> findAllWorkplaces() {
    return workplaceDataService.findAll();
  }

  @Override
  public void createWorkplace(WorkplaceDto workplaceDto) {
    try {
      workplaceDto.setRegDate(LocalDate.now());
      workplaceDataService.saveWorkplace(workplaceDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("workplace", "Name", workplaceDto.getWorkplaceName(), e);
    }
  }

  @Override
  public void updateWorkplace(WorkplaceDto workplaceDto) {
    if (!workplaceDataService.existsById(workplaceDto.getWorkplaceId())) {
      throw new IllegalArgumentException("Workplace with Name " + workplaceDto.getWorkplaceName() + " does not exist.");
    }
    workplaceDataService.saveWorkplace(workplaceDto);
  }

  @Override
  public void removeWorkplaces(List<WorkplaceDto> workplaces) {
    if (workplaces == null || workplaces.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (WorkplaceDto workplaceDto : workplaces) {
      if (workplaceDto == null) {
        throw new IllegalArgumentException("WorkplaceDto cannot be null");
      }
      ids.add(workplaceDto.getWorkplaceId());
    }

    try {
      workplaceDataService.deleteWorkplaces(ids);
    } catch (DuplicateKeyException e) {
      throw new RuntimeException("Database error occurred while deleting workplaces", e);
    }
  }
}
