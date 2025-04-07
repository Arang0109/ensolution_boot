package com.ensolution.ensol.controller.schedule;

import com.ensolution.ensol.dto.app.entity.ScheduleDto;
import com.ensolution.ensol.dto.app.query.HistoryDto;
import com.ensolution.ensol.dto.app.query.table.StackMeasurementTableDto;
import com.ensolution.ensol.dto.app.query.table.StackTableDto;
import com.ensolution.ensol.service.stack.StackMeasurementService;
import com.ensolution.ensol.service.stack.StackService;
import com.ensolution.ensol.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleRestController {
  private final ScheduleService scheduleService;
  private final StackService stackService;
  private final StackMeasurementService stackMeasurementService;

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
    List<StackMeasurementTableDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);
    List<HistoryDto> histories = stackService.findAllHistoryOfStacks(stackId);

    response.put("measurements", stackMeasurements);
    response.put("histories", histories);
    response.put("note", note);

    return ResponseEntity.ok(response);
  }
}
