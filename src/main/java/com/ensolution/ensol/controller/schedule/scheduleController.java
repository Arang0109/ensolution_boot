package com.ensolution.ensol.controller.schedule;

import com.ensolution.ensol.service.management.StackMeasurementService;
import com.ensolution.ensol.service.management.StackService;
import com.ensolution.ensol.service.management.WorkplaceService;
import com.ensolution.ensol.service.schedule.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class scheduleController {
  private final com.ensolution.ensol.service.schedule.scheduleService scheduleService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public scheduleController(WorkplaceService workplaceService, StackService stackService, StackMeasurementService stackMeasurementService, scheduleService scheduleService) {
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
    this.scheduleService = scheduleService;
  }

  @GetMapping("/list")
  public String scheduleMainView(Model m) {
    m.addAttribute("schedules", scheduleService.findAllSchedules());
    return "schedule/scheduleListView";
  }

  @GetMapping("/register")
  public String registerManager(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    return "schedule/scheduleRegisterView";
  }
}
