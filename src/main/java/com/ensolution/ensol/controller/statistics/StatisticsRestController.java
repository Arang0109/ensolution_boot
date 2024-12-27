package com.ensolution.ensol.controller.statistics;

import com.ensolution.ensol.domain.statistics.ChartDataResponse;
import com.ensolution.ensol.service.management.WorkplaceService;
import com.ensolution.ensol.service.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsRestController {
  WorkplaceService workplaceService;
  StatisticsService statisticsService;

  @Autowired
  public StatisticsRestController(WorkplaceService workplaceService, StatisticsService statisticsService) {
    this.workplaceService = workplaceService;
    this.statisticsService = statisticsService;
  }

  @GetMapping("/chart/workplace")
  public ChartDataResponse getChartStats(@RequestParam List<Integer> workplaceIds) {
    ChartDataResponse response = new ChartDataResponse();
    response.setCompleteStats(statisticsService.getCompleteStackCntOfWorkplace(workplaceIds));
    response.setNonCompleteStats(statisticsService.getNonCompleteStackCntOfWorkplace(workplaceIds));
    return response;
  }

  @GetMapping("/chart/all")
  public ChartDataResponse getChartStatsAll() {
    ChartDataResponse response = new ChartDataResponse();
    response.setCompleteStats(statisticsService.getCompleteStackCnt());
    response.setNonCompleteStats(statisticsService.getNonCompleteStackCnt());
    return response;
  }
}
