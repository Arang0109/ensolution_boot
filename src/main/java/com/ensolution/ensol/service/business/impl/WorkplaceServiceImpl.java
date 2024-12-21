package com.ensolution.ensol.service.business.impl;

import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.mapper.WorkplaceMapper;
import com.ensolution.ensol.service.business.WorkplaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
  private final WorkplaceMapper workplaceMapper;

  public WorkplaceServiceImpl(WorkplaceMapper workplaceMapper) {
    this.workplaceMapper = workplaceMapper;
  }

  @Override
  public List<WorkplaceDto> findWorkplacesByCompanyId(Integer id) {
    return workplaceMapper.selectWorkplacesOfCompany(id);
  }
}
