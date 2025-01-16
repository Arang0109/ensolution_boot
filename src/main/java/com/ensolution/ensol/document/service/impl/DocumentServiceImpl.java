package com.ensolution.ensol.document.service.impl;

import com.ensolution.ensol.document.service.DocumentService;
import com.ensolution.ensol.document.service.ScoreService;
import com.ensolution.ensol.management.domain.stack.PollutantDto;
import com.ensolution.ensol.management.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
  PollutantService pollutantService;
  ScoreService scoreService;

  @Autowired
  public DocumentServiceImpl(PollutantService pollutantService, ScoreService scoreService) {
    this.pollutantService = pollutantService;
    this.scoreService = scoreService;
  }

  @Override public List<PollutantDto> findPollutantsById(List<PollutantDto> pollutantDto) {
    List<PollutantDto> pollutants = new ArrayList<>();

    for (PollutantDto p : pollutantDto) {
      pollutants.add(pollutantService.findPollutantById(p.getPollutant_id()));
    }
    
    return pollutants;
  }
}
