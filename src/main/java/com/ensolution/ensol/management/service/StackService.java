package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.data.dto.stack.StackDto;
import com.ensolution.ensol.management.data.dto.stack.StackImagesDto;
import com.ensolution.ensol.management.data.dto.stack.StackInformationDto;
import com.ensolution.ensol.management.data.dto.stack.StackTableDto;
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
  void createStack(StackDto stack);
  void updateStack(StackDto stack);
  void updateStackInfo(StackInformationDto stackInformation, Integer stackId);
  void removeStacks(List<StackDto> stacks);
  void saveFile(MultipartFile file, Integer stackId) throws IOException;
}
