package com.ensolution.ensol.service.stack;

import com.ensolution.ensol.dto.app.entity.stack.StackDto;
import com.ensolution.ensol.dto.app.entity.stack.StackImageDto;
import com.ensolution.ensol.dto.app.entity.stack.StackInformationDto;
import com.ensolution.ensol.dto.app.query.HistoryDto;
import com.ensolution.ensol.dto.app.query.table.StackTableDto;
import com.ensolution.ensol.dto.app.query.IdentityDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StackService {
  StackDto findStackById(Integer stackId);
  List<StackDto> findAllStacks();
  List<StackDto> findStacksByWorkplaceId(Integer id);
  List<StackTableDto> findStacksOfTable();
  List<StackImageDto> findAllStackImages(Integer stackId);void createStack(StackDto stackDto);
  void updateStack(StackDto stack);
  void updateStackInfo(StackInformationDto stackInformation, Integer stackId);
  void removeStacks(List<StackDto> stacks);
  void saveFile(MultipartFile file, Integer stackId) throws IOException;
  IdentityDto findIds(Integer id);
  List<HistoryDto> findAllHistoryOfStacks(Integer stackId);
}
