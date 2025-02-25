package com.ensolution.ensol.controller.schedule;

import com.ensolution.ensol.service.stack.StackMeasurementService;
import com.ensolution.ensol.service.stack.StackService;
import com.ensolution.ensol.service.company.WorkplaceService;
import com.ensolution.ensol.service.schedule.ScheduleService;
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
  public String showSchedulePage(Model m) {
    m.addAttribute("schedules", scheduleService.findAllSchedules());
    return "schedule/calendarView";
  }

  @GetMapping("/register")
  public String showRegisterPage(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    return "schedule/scheduleRegisterView";
  }
}
