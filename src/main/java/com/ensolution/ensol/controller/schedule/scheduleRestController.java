package com.ensolution.ensol.controller.schedule;

import com.ensolution.ensol.domain.*;
import com.ensolution.ensol.domain.management.StackTableDto;
import com.ensolution.ensol.service.management.StackMeasurementService;
import com.ensolution.ensol.service.management.StackService;
import com.ensolution.ensol.service.management.WorkplaceService;
import com.ensolution.ensol.service.schedule.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class scheduleRestController {
  private final com.ensolution.ensol.service.schedule.scheduleService scheduleService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public scheduleRestController(WorkplaceService workplaceService, StackService stackService, StackMeasurementService stackMeasurementService, scheduleService scheduleService) {
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
    this.scheduleService = scheduleService;
  }

  @GetMapping("/register/getStack")
  public ResponseEntity<Map<String, Object>> getStackName(@RequestParam Integer workplaceId) {
    List<StackTableDto> stacks = stackService.findStacksByWorkplaceId(workplaceId);

    Map<String, Object> response = new HashMap<>();
    response.put("stacks", stacks);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/register/getStackMeasurement")
  public ResponseEntity<Map<String, Object>> getStackMeasurement(@RequestParam Integer stackId) {
    Map<String, Object> response = new HashMap<>();
    String note = stackService.findStackById(stackId).getNote();
    List<StackMeasurementDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);
    List<HistoryDto> histories = scheduleService.findAllHistoryOfStacks(stackId);

    response.put("measurements", stackMeasurements);
    response.put("histories", histories);
    response.put("note", note);

    return ResponseEntity.ok(response);
  }

  @PostMapping("/register/addSchedule")
  public void addPlan(@RequestBody List<ScheduleDto> scheduleDto) {
    // 1. datepicker 선택된 날짜 (measure_date)
    // 2. stack_measurement_id >> 여러개 >> schedule 여러개 >> ajax 로 처리
    for (ScheduleDto schedule : scheduleDto) {
      scheduleService.addNewSchedule(schedule);
    }
  }

  @DeleteMapping("/delete")
  public void deleteSchedule(@RequestBody List<Integer> schedule_ids) {
    scheduleService.removeSchedules(schedule_ids);
  }

  @PatchMapping("/update/complete")
  public void completeSchedule(@RequestBody List<Integer> schedule_ids) {
    scheduleService.updateScheduleComplete(schedule_ids);
  }
}
