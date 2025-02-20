package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.common.url.UrlConstants;
import com.ensolution.ensol.management.data.dto.stack.StackDto;
import com.ensolution.ensol.management.data.dto.stack.StackImagesDto;
import com.ensolution.ensol.management.data.dto.stack.StackInformationDto;
import com.ensolution.ensol.management.data.dto.stack.StackTableDto;
import com.ensolution.ensol.management.data.mapper.StackImagesMapper;
import com.ensolution.ensol.management.data.mapper.StackMapper;
import com.ensolution.ensol.management.data.mapper.WorkplaceMapper;
import com.ensolution.ensol.management.service.StackService;
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
  private final UrlConstants urlConstants;

  public StackServiceImpl(StackMapper stackMapper, WorkplaceMapper workplaceMapper, StackImagesMapper stackImagesMapper,
                          UrlConstants urlConstants) {
    this.stackMapper = stackMapper;
    this.workplaceMapper = workplaceMapper;
    this.stackImagesMapper = stackImagesMapper;
    this.urlConstants = urlConstants;
  }

  @Override
  public void saveFile(MultipartFile file, Integer stackId) throws IOException {
    File directory = new File(urlConstants.getUPLOAD_DIR());
    if (!directory.exists()) {
      directory.mkdirs();
    }

    String filePath = urlConstants.getUPLOAD_DIR() + File.separator + file.getOriginalFilename();

    File destinationFile = new File(filePath);
    file.transferTo(destinationFile);

    StackImagesDto stackImagesDto = new StackImagesDto();
    stackImagesDto.setStack_id(stackId);
    stackImagesDto.setImage_path(filePath);
    stackImagesDto.setImage_name(file.getOriginalFilename());

    stackImagesMapper.insert(stackImagesDto);
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
//    Integer company_id = workplaceMapper.selectWorkplace(workplace_id).getCompany_id();

//    map.put("company_id", company_id);
    map.put("workplace_id", workplace_id);

    return map;
  }

  @Override
  public void createStack(StackDto stackDto) {
    try {
      stackMapper.insert(stackDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("stack", "Name", stackDto.getStack_name(), e);
    }
  }

  @Override
  public void updateStack(StackDto stackDto) {
    StackDto existingStack = stackMapper.selectStack(stackDto.getStack_id());

    if (existingStack == null) {
      throw new IllegalArgumentException("Stack with Name " + stackDto.getStack_name() + " does not exist.");
    }

    stackMapper.update(stackDto);
  }

  @Override
  public void updateStackInfo(StackInformationDto stackInformationDto, Integer stackId) {
    stackInformationDto.setStack_info_id(stackId);
    stackMapper.updateStackInfo(stackInformationDto);
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
      ids.add(stackDto.getStack_id());
    }

    try {
      stackMapper.deleteItems(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting stacks", e);
    }
  }
}
