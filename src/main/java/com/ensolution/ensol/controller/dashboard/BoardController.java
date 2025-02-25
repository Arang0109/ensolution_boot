package com.ensolution.ensol.controller.dashboard;

import com.ensolution.ensol.service.company.WorkplaceService;
import com.ensolution.ensol.service.dashboard.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class BoardController {
  WorkplaceService workplaceService;
  BoardService boardService;

  // Test
  @Autowired
  public BoardController(WorkplaceService workplaceService, BoardService boardService) {
    this.workplaceService = workplaceService;
    this.boardService = boardService;
  }

  @GetMapping
  public String dashboardMainView(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    m.addAttribute("completeCnt", boardService.getChartStackCount().get("allCompleteCnt"));
    m.addAttribute("nonCompleteCnt", boardService.getChartStackCount().get("allCnt"));
    return "dashboard/dashboardMainView";
  }
}
