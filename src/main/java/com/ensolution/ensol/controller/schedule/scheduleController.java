package com.ensolution.ensol.controller.schedule;

import com.ensolution.ensol.service.management.StackMeasurementService;
import com.ensolution.ensol.service.management.StackService;
import com.ensolution.ensol.service.management.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class scheduleController {
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public scheduleController(WorkplaceService workplaceService, StackService stackService, StackMeasurementService stackMeasurementService) {
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
  }

  @GetMapping("/list")
  public String scheduleMainView(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    m.addAttribute("stacks", stackService.findAllStacks());
    return "schedule/scheduleListView";
  }
}
