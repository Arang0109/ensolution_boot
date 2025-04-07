package com.ensolution.ensol.service.document;

import com.ensolution.ensol.dto.app.entity.PollutantDto;

import java.util.List;
import java.util.Map;

public interface ScoreService {
  Map<String, String> CapabilityScorer(List<PollutantDto> pollutants);
}
