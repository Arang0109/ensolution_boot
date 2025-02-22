package com.ensolution.ensol.document.service.impl;

import com.ensolution.ensol.common.util.CapabilityScoreCalculator;
import com.ensolution.ensol.common.data.dto.stack.PollutantDto;
import com.ensolution.ensol.document.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {
  @Override
  public Map<String, String> CapabilityScorer(List<PollutantDto> pollutants) {
   CapabilityScoreCalculator calculator = new CapabilityScoreCalculator(pollutants);
   return calculator.getScore();
  }
}
