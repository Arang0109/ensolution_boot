package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.WorkplaceDto;
import com.ensolution.ensol.management.service.WorkplaceDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkplaceDataServiceImplTest {
  @Autowired
  WorkplaceDataService workplaceDataService;

  @Test
  void findWorkplacesByCompanyId() {
    List<WorkplaceDto> workplaces;

    workplaces = workplaceDataService.findWorkplacesByCompanyId(1);

    for (WorkplaceDto workplace : workplaces) {
      System.out.println(workplace.getWorkplaceName());
    }
  }
}