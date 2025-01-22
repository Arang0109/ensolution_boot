package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.stack.StackDto;
import com.ensolution.ensol.management.domain.stack.StackImagesDto;
import com.ensolution.ensol.management.domain.stack.StackInformationDto;
import com.ensolution.ensol.management.domain.stack.StackTableDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StackService {
  StackDto findStackById(Integer id);
  List<StackDto> findAllStacks();
  List<StackTableDto> findStacksByWorkplaceId(Integer id);
  List<StackTableDto> findStacksOfTable();
  List<StackImagesDto> findAllStackImages(Integer stackId);
  Map<String, Integer> getCompanyWorkplaceId(Integer id);
  Integer addNewStack(StackDto stack);
  Integer updateStack(StackDto stack);
  Integer updateStackInfo(StackInformationDto stackInformation, Integer stackId);
  Integer removeStacks(List<StackDto> stacks);
  Integer saveFile(MultipartFile file, Integer stackId) throws IOException;
}
