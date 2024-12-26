package com.ensolution.ensol.controller.document;

import com.ensolution.ensol.domain.PollutantDto;
import com.ensolution.ensol.service.document.ScoreService;
import com.ensolution.ensol.service.pollutant.PollutantService;
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

    Map map = scoreService.abilityScoreCal(pollutants);

    Map<String, Object> response = new HashMap<>();
    response.put("score", map.get("score"));

    return ResponseEntity.ok(response);
  }
}