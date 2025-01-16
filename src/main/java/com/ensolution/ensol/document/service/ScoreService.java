package com.ensolution.ensol.document.service;

import com.ensolution.ensol.management.domain.stack.PollutantDto;

import java.util.List;
import java.util.Map;

public interface ScoreService {
  Map abilityScoreCal(List<PollutantDto> pollutants);
}
