package com.ensolution.ensol.service.pollutant;

import com.ensolution.ensol.domain.management.stack.PollutantDto;

import java.util.List;

public interface PollutantService {
  PollutantDto findPollutantById(Integer id);
  List<PollutantDto> findAllPollutants();
}
