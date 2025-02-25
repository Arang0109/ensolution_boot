package com.ensolution.ensol.service.pollutant.impl;

import com.ensolution.ensol.dto.entity.PollutantDto;
import com.ensolution.ensol.entity.Pollutant;
import com.ensolution.ensol.mapper.PollutantMapper;
import com.ensolution.ensol.repository.jpa.pollutant.PollutantRepository;
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
        .orElseThrow(() -> new RuntimeException("pollutant not found"));

    return pollutantMapper.toDto(pollutant);
  }

  public List<PollutantDto> findAllPollutants() {
    return pollutantMapper.toDtoList(pollutantRepository.findAll());
  }
}
