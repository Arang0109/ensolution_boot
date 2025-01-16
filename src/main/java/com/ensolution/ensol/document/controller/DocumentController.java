package com.ensolution.ensol.document.controller;

import com.ensolution.ensol.management.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/document")
public class DocumentController {
  PollutantService pollutantService;

  @Autowired
  public DocumentController(PollutantService pollutantService) {
    this.pollutantService = pollutantService;
  }

  @GetMapping("/score")
  public String abilityScore(Model m) {
    m.addAttribute("pollutants", pollutantService.findAllPollutants());
    return "document/abilityScore";
  }
}