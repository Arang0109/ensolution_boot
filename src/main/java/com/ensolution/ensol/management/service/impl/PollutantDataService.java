package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.PollutantDto;
import com.ensolution.ensol.common.data.entity.Pollutant;
import com.ensolution.ensol.common.data.mapper.PollutantMapper;
import com.ensolution.ensol.common.data.repository.PollutantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollutantDataService {
  private final PollutantRepository pollutantRepository;
  private final PollutantMapper pollutantMapper;

  public PollutantDto findPollutantById(Integer pollutantId) {
    Pollutant pollutant = pollutantRepository.findById(pollutantId)
        .orElseThrow(() -> new RuntimeException("pollutat not found"));

    return pollutantMapper.toDto(pollutant);
  }

  public List<PollutantDto> findAllPollutants() {
    return pollutantMapper.toDtoList(pollutantRepository.findAll());
  }
}
