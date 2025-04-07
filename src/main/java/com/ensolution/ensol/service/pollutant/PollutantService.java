package com.ensolution.ensol.service.pollutant;

import com.ensolution.ensol.dto.app.entity.PollutantDto;

import java.util.List;

public interface PollutantService {
  PollutantDto findPollutantById(Integer id);
  List<PollutantDto> findAllPollutants();
}
