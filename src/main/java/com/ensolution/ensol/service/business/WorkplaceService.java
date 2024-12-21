package com.ensolution.ensol.service.business;

import com.ensolution.ensol.domain.WorkplaceDto;

import java.util.List;

public interface WorkplaceService {
  List<WorkplaceDto> findWorkplacesByCompanyId(Integer id);
}
