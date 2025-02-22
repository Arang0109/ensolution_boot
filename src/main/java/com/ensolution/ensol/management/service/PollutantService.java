package com.ensolution.ensol.management.service;

import com.ensolution.ensol.common.data.dto.stack.PollutantDto;

import java.util.List;

public interface PollutantService {
  PollutantDto findPollutantById(Integer id);
  List<PollutantDto> findAllPollutants();
}
