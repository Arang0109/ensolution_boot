package com.ensolution.ensol.service;

import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.mapper.WorkplaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {
  private final WorkplaceMapper workplaceMapper;

  public WorkplaceService(WorkplaceMapper workplaceMapper) {
    this.workplaceMapper = workplaceMapper;
  }

  public List<WorkplaceDto> getWorkplacesOfCompany(Integer id) {
    return workplaceMapper.selectWorkplaces(id);
  }
}
