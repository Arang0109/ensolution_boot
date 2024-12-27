package com.ensolution.ensol.service.management.impl;

import com.ensolution.ensol.domain.management.company.DepartmentDto;
import com.ensolution.ensol.domain.management.company.SubFactoryDto;
import com.ensolution.ensol.domain.management.company.WorkplaceDto;
import com.ensolution.ensol.mapper.WorkplaceMapper;
import com.ensolution.ensol.service.management.WorkplaceService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
  private final WorkplaceMapper workplaceMapper;

  public WorkplaceServiceImpl(WorkplaceMapper workplaceMapper) {
    this.workplaceMapper = workplaceMapper;
  }

  @Override
  public WorkplaceDto findWorkplaceById(Integer id) {
    return workplaceMapper.selectWorkplace(id);
  }

  @Override
  public List<WorkplaceDto> findWorkplacesByCompanyId(Integer id) {
    return workplaceMapper.selectWorkplacesOfCompany(id);
  }

  @Override
  public List<WorkplaceDto> findAllWorkplaces() {
    return workplaceMapper.selectAll();
  }

  @Override
  public List<SubFactoryDto> findSubFactoriesByWorkplaceId(Integer id) {
    return workplaceMapper.selectFactory(id);
  }

  @Override
  public List<DepartmentDto> findDepartmentsByWorkplaceId(Integer id) {
    return workplaceMapper.selectDepartment(id);
  }

  @Override
  public Integer addNewWorkplace(WorkplaceDto workplaceDto) {
    try {
      return workplaceMapper.insert(workplaceDto);
    } catch (DuplicateKeyException e) {
      throw new DuplicateKeyException("Failed to add workplace. Duplicate key for Name: " + workplaceDto.getWorkplace_name(), e);
    }
  }

  @Override
  public Integer updateWorkplace(WorkplaceDto workplaceDto) {
    WorkplaceDto existingWorkplace = workplaceMapper.selectWorkplace(workplaceDto.getWorkplace_id());

    if (existingWorkplace == null) {
      throw new IllegalArgumentException("Workplace with Name " + workplaceDto.getWorkplace_name() + " does not exist.");
    }

    if (existingWorkplace.equals(workplaceDto)) {
      System.out.println("No changes detected for Workplace Name: " + workplaceDto.getWorkplace_name());
      return 0;
    }

    return workplaceMapper.update(workplaceDto);
  }

  @Override
  public Integer removeWorkplaces(List<WorkplaceDto> workplaces) {
    if (workplaces == null || workplaces.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (WorkplaceDto workplaceDto : workplaces) {
      if (workplaceDto == null) {
        throw new IllegalArgumentException("WorkplaceDto cannot be null");
      }
      ids.add(workplaceDto.getWorkplace_id());
    }

    try {
      return workplaceMapper.deleteItems(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting workplaces", e);
    }
  }
}
