package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.StackImageDto;
import com.ensolution.ensol.common.data.dto.StackInformationDto;
import com.ensolution.ensol.common.data.dto.stack.TableIdDto;
import com.ensolution.ensol.common.data.mapper.mybatis.GetIdMapper;
import com.ensolution.ensol.common.data.mapper.mybatis.TableBatisMapper;
import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.common.data.dto.StackDto;
import com.ensolution.ensol.common.data.dto.stack.StackTableDto;
import com.ensolution.ensol.management.service.StackDataService;
import com.ensolution.ensol.management.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService {
  private final StackDataService stackDataService;
  private final TableBatisMapper tableBatisMapper;
  private final GetIdMapper getIdMapper;

  @Override
  public List<StackImageDto> findAllStackImages(Integer stackId) {
    return stackDataService.findAllStackImages(stackId);
  }

  @Override
  public StackDto findStackById(Integer stackId) {
    return stackDataService.findStackById(stackId);
  }

  @Override
  public List<StackDto> findAllStacks() {
    return stackDataService.findAllStacks();
  }

  // 특정 사업장의 시설 테이블 목록
  @Override
  public List<StackTableDto> findStacksByWorkplaceId(Integer workplaceId) {
    return tableBatisMapper.selectStacksByWorkplaceOfTable(workplaceId);
  }

  // 전체 시설 테이블 목록
  @Override
  public List<StackTableDto> findStacksOfTable() {
    return tableBatisMapper.selectStacksOfTable();
  }

  @Override
  public void createStack(StackDto stackDto) {
    try {
      stackDto.setRegDate(LocalDate.now());
      stackDataService.saveStack(stackDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("stack", "Name", stackDto.getStackName(), e);
    }
  }

  @Override
  public void updateStack(StackDto stackDto) {
    if (!stackDataService.existsStackById(stackDto.getStackId())) {
      throw new IllegalArgumentException("Stack with Name " + stackDto.getStackName() + " does not exist.");
    }

    stackDataService.updateStack(stackDto);
  }

  @Override
  public void updateStackInfo(StackInformationDto stackInformationDto, Integer stackId) {
    stackInformationDto.setStackId(stackId);
    stackDataService.saveStackInformation(stackInformationDto);
  }

  @Override
  public void removeStacks(List<StackDto> stacks) {
    if (stacks == null || stacks.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (StackDto stackDto : stacks) {
      if (stackDto == null) {
        throw new IllegalArgumentException("StackDto cannot be null");
      }
      ids.add(stackDto.getStackId());
    }

    try {
      stackDataService.deleteStacks(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting stacks", e);
    }
  }

  @Override
  public void saveFile(MultipartFile file, Integer stackId) throws IOException {
    File directory = new File("C:/EnSolution/uploads");
    if (!directory.exists()) {
      directory.mkdirs();
    }

    String filePath = "C:/EnSolution/uploads" + File.separator + file.getOriginalFilename();

    File destinationFile = new File(filePath);
    file.transferTo(destinationFile);

    StackImageDto stackImageDto = new StackImageDto();
    stackImageDto.setStackId(stackId);
    stackImageDto.setImagePath(filePath);
    stackImageDto.setImageName(file.getOriginalFilename());

    stackDataService.saveStackImage(stackImageDto);
  }

  @Override
  public TableIdDto findIds(Integer stackId) {
    return getIdMapper.getIds(stackId);
  }
}
