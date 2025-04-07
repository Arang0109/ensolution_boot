package com.ensolution.ensol.service.schedule.impl;

import com.ensolution.ensol.dto.app.entity.ScheduleDto;
import com.ensolution.ensol.entity.app.Schedule;
import com.ensolution.ensol.mapper.app.ScheduleMapper;
import com.ensolution.ensol.repository.app.mybatis.ScheduleTableMapper;
import com.ensolution.ensol.repository.app.jpa.schedule.ScheduleRepository;
import com.ensolution.ensol.dto.app.query.table.ScheduleTableDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleDataService {
  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper scheduleMapper;
  private final ScheduleTableMapper scheduleTableMapper;

  public List<ScheduleTableDto> findAllSchedules() {
    return scheduleTableMapper.selectSchedules();
  }

  public void createSchedule(ScheduleDto scheduleDto) {
    scheduleRepository.save(
      scheduleMapper.toEntity(scheduleDto)
    );
  }

  public void completeSchedules(List<Integer> scheduleIds) {
    List<Integer> stackMeasurementIds = new ArrayList<>();
    for (Integer scheduleId : scheduleIds) {
      Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
      ScheduleDto scheduleDto = scheduleMapper.toDto(schedule);
      stackMeasurementIds.add(scheduleDto.getStackMeasurementId());
    }
    try {
      scheduleTableMapper.updateStackMeasurementComplete(stackMeasurementIds);
      scheduleTableMapper.updateScheduleComplete(scheduleIds);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting schedules", e);
    }
  }

  public void removeSchedules(List<Integer> scheduleIds) {
    scheduleRepository.deleteAllById(scheduleIds);
  }
}
