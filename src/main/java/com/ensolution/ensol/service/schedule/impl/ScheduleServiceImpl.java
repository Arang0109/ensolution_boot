package com.ensolution.ensol.service.schedule.impl;

import com.ensolution.ensol.domain.HistoryDto;
import com.ensolution.ensol.domain.ScheduleDto;
import com.ensolution.ensol.domain.ScheduleTableDto;
import com.ensolution.ensol.mapper.ScheduleMapper;
import com.ensolution.ensol.mapper.StackMeasurementMapper;
import com.ensolution.ensol.service.schedule.ScheduleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
  private final ScheduleMapper scheduleMapper;
  private final StackMeasurementMapper stackMeasurementMapper;

  public ScheduleServiceImpl(ScheduleMapper scheduleMapper, StackMeasurementMapper stackMeasurementMapper) {
    this.scheduleMapper = scheduleMapper;
    this.stackMeasurementMapper = stackMeasurementMapper;
  }

  @Override
  public List<ScheduleTableDto> findAllSchedules() {
    return scheduleMapper.selectAll();
  }

  @Override
  public List<HistoryDto> findAllHistoryOfStacks(Integer stack_id) {
    return scheduleMapper.selectStackHistory(stack_id);
  }

  @Override
  public void addNewSchedule(ScheduleDto scheduleDto) {
    scheduleDto.setIs_completed(false);
    scheduleMapper.insert(scheduleDto);
  }

  @Override
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

  @Override
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
