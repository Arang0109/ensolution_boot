package com.ensolution.ensol.schedule.controller;

import com.ensolution.ensol.management.service.StackMeasurementService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
  ScheduleService scheduleService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public ScheduleController(WorkplaceService workplaceService, StackService stackService, StackMeasurementService stackMeasurementService, ScheduleService scheduleService) {
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
    this.scheduleService = scheduleService;
  }

  @GetMapping("/calendar")
  public String scheduleMainView(Model m) {
    m.addAttribute("schedules", scheduleService.findAllSchedules());
    return "schedule/calendarView";
  }

  @GetMapping("/register")
  public String registerManager(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    return "schedule/scheduleRegisterView";
  }
}
