package com.ensolution.ensol.service.pollutant.impl;

import com.ensolution.ensol.domain.PollutantDto;
import com.ensolution.ensol.mapper.PollutantMapper;
import com.ensolution.ensol.service.pollutant.PollutantService;
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
