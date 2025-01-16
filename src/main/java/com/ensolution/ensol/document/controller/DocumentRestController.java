package com.ensolution.ensol.document.controller;

import com.ensolution.ensol.management.domain.stack.PollutantDto;
import com.ensolution.ensol.document.service.ScoreService;
import com.ensolution.ensol.management.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class DocumentRestController {
  PollutantService pollutantService;
  ScoreService scoreService;

  @Autowired
  public DocumentRestController(PollutantService pollutantService, ScoreService scoreService) {
    this.pollutantService = pollutantService;
    this.scoreService = scoreService;
  }

  @PostMapping("/score/calculation")
  public ResponseEntity<Map<String, Object>> calScore(@RequestBody List<PollutantDto> pollutantDto) {
    List<PollutantDto> pollutants = new ArrayList<>();

    for (PollutantDto p : pollutantDto) {
      pollutants.add(pollutantService.findPollutantById(p.getPollutant_id()));
    }

    Map<String, Object> response = new HashMap<>();
    response.put("score", scoreService.abilityScoreCal(pollutants).get("score"));

    return ResponseEntity.ok(response);
  }
}