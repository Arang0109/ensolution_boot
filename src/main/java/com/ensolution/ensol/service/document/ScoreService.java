package com.ensolution.ensol.service.document;

import com.ensolution.ensol.domain.PollutantDto;

import java.util.List;
import java.util.Map;

public interface ScoreService {
  Map abilityScoreCal(List<PollutantDto> pollutants);
}
