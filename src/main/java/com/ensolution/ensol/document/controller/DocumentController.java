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

  /**
   * 측정가용능력 점수 계산
   *
   * @param m Model 객체
   * 모델 데이터
   * - "pollutants" : 오염 물질 목록 데이터 pollutantService.findAllPollutants()
   * @return 측정가용능력 점수 계산 페이지
   */
  @GetMapping("/availability-score")
  public String showAvailabilityScorePage(Model m) {
    m.addAttribute("pollutants", pollutantService.findAllPollutants());
    return "document/availabilityScore";
  }
}