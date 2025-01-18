package com.ensolution.ensol.statistic.controller;

import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.statistic.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
  WorkplaceService workplaceService;
  StatisticsService statisticsService;

  @Autowired
  public StatisticsController(WorkplaceService workplaceService, StatisticsService statisticsService) {
    this.workplaceService = workplaceService;
    this.statisticsService = statisticsService;
  }

  @GetMapping
  public String statisticsMainView(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    m.addAttribute("completeCnt", statisticsService.getChartStackCount().get("allCompleteCnt"));
    m.addAttribute("nonCompleteCnt", statisticsService.getChartStackCount().get("allCnt"));
    return "statistics/statisticsMainView";
  }
}
