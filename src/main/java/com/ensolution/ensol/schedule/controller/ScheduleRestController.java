package com.ensolution.ensol.schedule.controller;

import com.ensolution.ensol.common.data.dto.ScheduleDto;
import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.dto.stack.StackTableDto;
import com.ensolution.ensol.schedule.domain.HistoryDto;
import com.ensolution.ensol.management.service.StackMeasurementService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {
  ScheduleService scheduleService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public ScheduleRestController(WorkplaceService workplaceService, StackService stackService,
                                StackMeasurementService stackMeasurementService, ScheduleService scheduleService) {
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
    this.scheduleService = scheduleService;
  }

  @DeleteMapping("/calendar")
  public void deleteSchedule(@RequestBody List<Integer> schedule_ids) {
    scheduleService.removeSchedules(schedule_ids);
  }

  @PatchMapping("/calendar/complete")
  public void completeSchedule(@RequestBody List<Integer> scheduleIds) {
    scheduleService.completeSchedules(scheduleIds);
  }

  @PostMapping("/register")
  public void addPlan(@RequestBody List<ScheduleDto> scheduleDto) {
    // 1. datepicker 선택된 날짜 (measure_date)
    // 2. stack_measurement_id >> 여러개 >> schedule 여러개 >> ajax 로 처리
    for (ScheduleDto schedule : scheduleDto) {
      scheduleService.createSchedule(schedule);
    }
  }

  @GetMapping("/register/stacks")
  public ResponseEntity<Map<String, Object>> getStacksOfWorkplace(@RequestParam Integer workplaceId) {
    List<StackTableDto> stacks = stackService.findStacksByWorkplaceId(workplaceId);

    Map<String, Object> response = new HashMap<>();
    response.put("stacks", stacks);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/register/stack-measurements")
  public ResponseEntity<Map<String, Object>> getStackMeasurementsOfStack(@RequestParam Integer stackId) {
    Map<String, Object> response = new HashMap<>();
    String note = stackService.findStackById(stackId).getNote();
    List<StackMeasurementDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);
//    List<HistoryDto> histories = scheduleService.findAllHistoryOfStacks(stackId);

    response.put("measurements", stackMeasurements);
//    response.put("histories", scheduleService.historyFormater(histories));
    response.put("note", note);

    return ResponseEntity.ok(response);
  }
}
