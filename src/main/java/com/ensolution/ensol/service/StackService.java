package com.ensolution.ensol.service;

import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.mapper.StackMapper;
import com.ensolution.ensol.mapper.WorkplaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StackService {
  private final StackMapper stackMapper;

  public StackService(StackMapper stackMapper) {
    this.stackMapper = stackMapper;
  }

  public StackDto getStack(Integer id) {
    return stackMapper.selectStack(id);
  }
}
