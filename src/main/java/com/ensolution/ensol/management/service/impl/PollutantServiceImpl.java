package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.management.domain.stack.PollutantDto;
import com.ensolution.ensol.management.service.PollutantService;
import com.ensolution.ensol.management.mapper.PollutantMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollutantServiceImpl implements PollutantService {
  private final PollutantMapper pollutantMapper;

  public PollutantServiceImpl(PollutantMapper pollutantMapper) {
    this.pollutantMapper = pollutantMapper;
  }

  @Override
  public PollutantDto findPollutantById(Integer id) {
    return pollutantMapper.selectPollutant(id);
  }

  @Override
  public List<PollutantDto> findAllPollutants() {
    return pollutantMapper.selectAll();
  }
}
