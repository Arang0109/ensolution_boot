package com.ensolution.ensol.service.business.impl;

import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.mapper.StackMapper;
import com.ensolution.ensol.service.business.StackService;
import org.springframework.stereotype.Service;

@Service
public class StackServiceImpl implements StackService {
  private final StackMapper stackMapper;

  public StackServiceImpl(StackMapper stackMapper) {
    this.stackMapper = stackMapper;
  }

  @Override
  public StackDto getStack(Integer id) {
    return stackMapper.selectStack(id);
  }
}
