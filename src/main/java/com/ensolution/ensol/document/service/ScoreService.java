package com.ensolution.ensol.document.service;

import com.ensolution.ensol.common.data.dto.stack.PollutantDto;

import java.util.List;
import java.util.Map;

public interface ScoreService {
  Map<String, String> CapabilityScorer(List<PollutantDto> pollutants);
}
