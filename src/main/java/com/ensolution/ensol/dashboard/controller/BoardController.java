package com.ensolution.ensol.dashboard.controller;

import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.dashboard.service.BoardService;
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
