package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.domain.stack.StackDto;
import com.ensolution.ensol.management.domain.stack.StackImagesDto;
import com.ensolution.ensol.management.domain.stack.StackInformationDto;
import com.ensolution.ensol.management.domain.stack.StackTableDto;
import com.ensolution.ensol.management.mapper.StackImagesMapper;
import com.ensolution.ensol.management.mapper.StackMapper;
import com.ensolution.ensol.management.mapper.WorkplaceMapper;
import com.ensolution.ensol.management.service.StackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StackServiceImpl implements StackService {
  private final StackMapper stackMapper;
  private final WorkplaceMapper workplaceMapper;
  private final StackImagesMapper stackImagesMapper;
  @Value("${file.upload_dir}")
  private String uploadDir;

  public StackServiceImpl(StackMapper stackMapper, WorkplaceMapper workplaceMapper, StackImagesMapper stackImagesMapper) {
    this.stackMapper = stackMapper;
    this.workplaceMapper = workplaceMapper;
    this.stackImagesMapper = stackImagesMapper;
  }

  @Override
  public Integer saveFile(MultipartFile file, Integer stackId) throws IOException {
    File directory = new File(uploadDir);
    if (!directory.exists()) {
      directory.mkdirs();
    }

    String filePath = uploadDir + File.separator + file.getOriginalFilename();

    File destinationFile = new File(filePath);
    file.transferTo(destinationFile);

    StackImagesDto stackImagesDto = new StackImagesDto();
    stackImagesDto.setStack_id(stackId);
    stackImagesDto.setImage_path(filePath);
    stackImagesDto.setImage_name(file.getOriginalFilename());

    return stackImagesMapper.insert(stackImagesDto);
  }

  @Override
  public List<StackImagesDto> findAllStackImages(Integer stackId) {
    return stackImagesMapper.selectAllImagesByStackId(stackId);
  }

  @Override
  public StackDto findStackById(Integer id) {
    return stackMapper.selectStack(id);
  }

  @Override
  public List<StackDto> findAllStacks() {
    return stackMapper.selectAll();
  }

  @Override
  public List<StackTableDto> findStacksByWorkplaceId(Integer id) {
    return stackMapper.selectStacksOfWorkplace(id);
  }

  @Override
  public List<StackTableDto> findStacksOfTable() {
    return stackMapper.selectAllOfTable();
  }

  @Override
  public Map<String, Integer> getCompanyWorkplaceId(Integer id) {
    Map<String, Integer> map = new HashMap<>();
    Integer workplace_id = stackMapper.selectStack(id).getWorkplace_id();
    Integer company_id = workplaceMapper.selectWorkplace(workplace_id).getCompany_id();

    map.put("company_id", company_id);
    map.put("workplace_id", workplace_id);

    return map;
  }

  @Override
  public Integer addNewStack(StackDto stackDto) {
    try {
      return stackMapper.insert(stackDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("stack", "Name", stackDto.getStack_name(), e);
    }
  }

  @Override
  public Integer updateStack(StackDto stackDto) {
    StackDto existingStack = stackMapper.selectStack(stackDto.getStack_id());

    if (existingStack == null) {
      throw new IllegalArgumentException("Stack with Name " + stackDto.getStack_name() + " does not exist.");
    }

    return stackMapper.update(stackDto);
  }

  @Override
  public Integer updateStackInfo(StackInformationDto stackInformationDto, Integer stackId) {
    stackInformationDto.setStack_info_id(stackId);
    return stackMapper.updateStackInfo(stackInformationDto);
  }

  @Override
  public Integer removeStacks(List<StackDto> stacks) {
    if (stacks == null || stacks.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (StackDto stackDto : stacks) {
      if (stackDto == null) {
        throw new IllegalArgumentException("StackDto cannot be null");
      }
      ids.add(stackDto.getStack_id());
    }

    try {
      return stackMapper.deleteItems(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting stacks", e);
    }
  }
}
