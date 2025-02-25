package com.ensolution.ensol.controller.document;

import com.ensolution.ensol.service.document.DocumentService;
import com.ensolution.ensol.dto.entity.PollutantDto;
import com.ensolution.ensol.service.document.ScoreService;
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
  public ResponseEntity<Map<String, Object>> calculateAvailabilityScore(@RequestBody List<PollutantDto> pollutants) {
    Map<String, Object> response = new HashMap<>();

    response.put("score",
        scoreService
            .CapabilityScorer(documentService.selectPollutlantsList(pollutants))
            .get("score"));

    return ResponseEntity.ok(response);
  }
}