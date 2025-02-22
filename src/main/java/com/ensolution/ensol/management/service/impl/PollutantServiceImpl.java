package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.PollutantDto;
import com.ensolution.ensol.management.service.PollutantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollutantServiceImpl implements PollutantService {
  private final PollutantDataService pollutantDataService;

  @Override
  public PollutantDto findPollutantById(Integer pollutantId) {
    return pollutantDataService.findPollutantById(pollutantId);
  }

  @Override
  public List<PollutantDto> findAllPollutants() {
    return pollutantDataService.findAllPollutants();
  }
}
