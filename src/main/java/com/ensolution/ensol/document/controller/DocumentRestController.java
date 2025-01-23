package com.ensolution.ensol.document.controller;

import com.ensolution.ensol.document.service.DocumentService;
import com.ensolution.ensol.management.domain.stack.PollutantDto;
import com.ensolution.ensol.document.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class DocumentRestController {
  DocumentService documentService;
  ScoreService scoreService;

  @Autowired
  public DocumentRestController(DocumentService documentService, ScoreService scoreService) {
    this.documentService = documentService;
    this.scoreService = scoreService;
  }

  @PostMapping("/availability-score")
  public ResponseEntity<Map<String, Object>> calScore(@RequestBody List<PollutantDto> pollutantDto) {
    List<PollutantDto> pollutants = documentService.findPollutantsById(pollutantDto);
    Map<String, Object> response = new HashMap<>();
    response.put("score", scoreService.CapabilityScorer(pollutants).get("score"));

    return ResponseEntity.ok(response);
  }
}