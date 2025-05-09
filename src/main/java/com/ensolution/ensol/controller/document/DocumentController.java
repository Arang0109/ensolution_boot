package com.ensolution.ensol.controller.document;

import com.ensolution.ensol.service.pollutant.PollutantService;
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

  /** 측정가용능력 점수 계산 */
  @GetMapping("/availability-score")
  public String showAvailabilityScorePage(Model m) {
    m.addAttribute("pollutants", pollutantService.findAllPollutants());
    return "document/availabilityScore";
  }
}