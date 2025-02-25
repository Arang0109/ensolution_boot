package com.ensolution.ensol.service.document;

import com.ensolution.ensol.dto.entity.PollutantDto;

import java.util.List;
import java.util.Map;

public interface ScoreService {
  Map<String, String> CapabilityScorer(List<PollutantDto> pollutants);
}
