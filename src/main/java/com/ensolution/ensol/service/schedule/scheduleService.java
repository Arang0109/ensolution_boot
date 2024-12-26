package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.domain.HistoryDto;
import com.ensolution.ensol.domain.ScheduleDto;
import com.ensolution.ensol.domain.ScheduleTableDto;
import com.ensolution.ensol.mapper.ScheduleMapper;
import com.ensolution.ensol.mapper.StackMeasurementMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class scheduleService {
  private final ScheduleMapper scheduleMapper;
  private final StackMeasurementMapper stackMeasurementMapper;

  public scheduleService(ScheduleMapper scheduleMapper, StackMeasurementMapper stackMeasurementMapper) {
    this.scheduleMapper = scheduleMapper;
    this.stackMeasurementMapper = stackMeasurementMapper;
  }

  public List<ScheduleTableDto> findAllSchedules() {
    return scheduleMapper.selectAll();
  }

  public List<HistoryDto> findAllHistoryOfStacks(Integer stack_id) {
    return scheduleMapper.selectStackHistory(stack_id);
  }

  public void addNewSchedule(ScheduleDto scheduleDto) {
    scheduleDto.setIs_completed(false);
    scheduleMapper.insert(scheduleDto);
  }

  public void updateScheduleComplete(List<Integer> schedule_ids) {
    List<Integer> stack_measurement_ids = new ArrayList<>();
    for (Integer schedule_id : schedule_ids) {
      ScheduleDto scheduleDto = scheduleMapper.selectSchedule(schedule_id);
      stack_measurement_ids.add(scheduleDto.getStack_measurement_id());
    }
    try {
      stackMeasurementMapper.updateComplete(stack_measurement_ids);
      scheduleMapper.updateComplete(schedule_ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting schedules", e);
    }
  }

  public void removeSchedules(List<Integer> schedule_ids) {
    List<Integer> stack_measurement_ids = new ArrayList<>();
    for (Integer schedule_id : schedule_ids) {
      ScheduleDto scheduleDto = scheduleMapper.selectSchedule(schedule_id);
      stack_measurement_ids.add(scheduleDto.getStack_measurement_id());
    }
    try {
      stackMeasurementMapper.updateNonComplete(stack_measurement_ids);
      scheduleMapper.deleteItems(schedule_ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting schedules", e);
    }
  }
}
