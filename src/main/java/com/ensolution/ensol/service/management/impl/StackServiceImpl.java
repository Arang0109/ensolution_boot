package com.ensolution.ensol.service.management.impl;

import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.domain.StackInformationDto;
import com.ensolution.ensol.domain.management.StackTableDto;
import com.ensolution.ensol.mapper.StackMapper;
import com.ensolution.ensol.mapper.WorkplaceMapper;
import com.ensolution.ensol.service.management.StackService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StackServiceImpl implements StackService {
  private final StackMapper stackMapper;
  private final WorkplaceMapper workplaceMapper;

  public StackServiceImpl(StackMapper stackMapper, WorkplaceMapper workplaceMapper) {
    this.stackMapper = stackMapper;
    this.workplaceMapper = workplaceMapper;
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
      throw new DuplicateKeyException("Failed to add stack. Duplicate key for Name: " + stackDto.getStack_name(), e);
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
  public Integer updateStackInfo(StackInformationDto stackInformationDto) {
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
