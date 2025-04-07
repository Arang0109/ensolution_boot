package com.ensolution.ensol.service.document.impl;

import com.ensolution.ensol.service.document.DocumentService;
import com.ensolution.ensol.service.document.ScoreService;
import com.ensolution.ensol.dto.app.entity.PollutantDto;
import com.ensolution.ensol.service.pollutant.PollutantService;
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

  @Override public List<PollutantDto> selectPollutlantsList(List<PollutantDto> pollutantDto) {
    List<PollutantDto> pollutants = new ArrayList<>();

    for (PollutantDto p : pollutantDto) {
      pollutants.add(pollutantService.findPollutantById(p.getPollutantId()));
    }
    
    return pollutants;
  }
}
