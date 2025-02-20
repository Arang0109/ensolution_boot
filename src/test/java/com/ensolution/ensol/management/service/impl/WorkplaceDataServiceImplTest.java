package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.management.data.dto.company.WorkplaceDto;
import com.ensolution.ensol.management.service.WorkplaceDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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