package com.ensolution.ensol.controller.dashboard;

import com.ensolution.ensol.common.util.ChartDataResponse;
import com.ensolution.ensol.service.company.WorkplaceService;
import com.ensolution.ensol.service.dashboard.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class BoardRestController {
  WorkplaceService workplaceService;
  BoardService boardService;

  @Autowired
  public BoardRestController(WorkplaceService workplaceService, BoardService boardService) {
    this.workplaceService = workplaceService;
    this.boardService = boardService;
  }

  @GetMapping("/chart/workplaces")
  public ChartDataResponse getChartStats(@RequestParam List<Integer> workplaceIds) {
    return new ChartDataResponse(
        boardService.getChartStackCountByWorkplace(workplaceIds).get("workplaceCompleteCnt"),
        boardService.getChartStackCountByWorkplace(workplaceIds).get("workplaceCnt"));
  }

  @GetMapping("/chart/global")
  public ChartDataResponse getChartStatsAll() {
    return new ChartDataResponse(
        boardService.getChartStackCount().get("allCompleteCnt"),
        boardService.getChartStackCount().get("allCnt")
    );
  }
}
