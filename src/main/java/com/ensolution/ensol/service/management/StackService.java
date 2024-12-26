package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.domain.StackInformationDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.domain.management.StackTableDto;

import java.util.List;
import java.util.Map;

public interface StackService {
  StackDto findStackById(Integer id);
  List<StackDto> findAllStacks();
  List<StackTableDto> findStacksByWorkplaceId(Integer id);
  List<StackTableDto> findStacksOfTable();
  Map<String, Integer> getCompanyWorkplaceId(Integer id);
  Integer addNewStack(StackDto stack);
  Integer updateStack(StackDto stack);
  Integer updateStackInfo(StackInformationDto stackInformation);
  Integer removeStacks(List<StackDto> stacks);
}
