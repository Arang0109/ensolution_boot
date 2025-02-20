package com.ensolution.ensol.schedule.service.impl;

import com.ensolution.ensol.schedule.domain.HistoryDto;
import com.ensolution.ensol.schedule.domain.ScheduleDto;
import com.ensolution.ensol.schedule.domain.ScheduleTableDto;
import com.ensolution.ensol.management.data.mapper.PollutantMapper;
import com.ensolution.ensol.schedule.mapper.ScheduleMapper;
import com.ensolution.ensol.management.data.mapper.StackMeasurementMapper;
import com.ensolution.ensol.schedule.service.ScheduleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
  private final ScheduleMapper scheduleMapper;
  private final StackMeasurementMapper stackMeasurementMapper;
  private final PollutantMapper pollutantMapper;

  public ScheduleServiceImpl(ScheduleMapper scheduleMapper, StackMeasurementMapper stackMeasurementMapper, PollutantMapper pollutantMapper) {
    this.scheduleMapper = scheduleMapper;
    this.stackMeasurementMapper = stackMeasurementMapper;
    this.pollutantMapper = pollutantMapper;
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
  public List<HistoryDto> historyFormater(List<HistoryDto> histories) {
    for (HistoryDto history : histories) {
      StringBuilder pollutants = new StringBuilder();
      String pollutant_ids = history.getPollutant_ids();

      for (String id : pollutant_ids.split(",")) {
        String name = pollutantMapper.selectPollutant(Integer.parseInt(id)).getPollutant_name();
        pollutants.append(name).append(", ");
      }

      if (!pollutants.isEmpty()) {
        pollutants.setLength(pollutants.length() - 2);
      }

      history.setPollutant_ids(pollutants.toString());
    }
    return histories;
  }

  @Override
  public void createSchedule(ScheduleDto scheduleDto) {
    scheduleDto.setIs_completed(false);
    scheduleMapper.insert(scheduleDto);
  }

  @Override
  public void completeSchedules(List<Integer> schedule_ids) {
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
