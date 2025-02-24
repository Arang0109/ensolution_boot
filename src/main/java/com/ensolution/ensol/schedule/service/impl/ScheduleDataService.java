package com.ensolution.ensol.schedule.service.impl;

import com.ensolution.ensol.common.data.dto.ScheduleDto;
import com.ensolution.ensol.common.data.entity.Schedule;
import com.ensolution.ensol.common.data.mapper.ScheduleMapper;
import com.ensolution.ensol.common.data.mapper.mybatis.ScheduleTableBatisMapper;
import com.ensolution.ensol.common.data.repository.ScheduleRepository;
import com.ensolution.ensol.schedule.domain.ScheduleTableDto;
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
  private final ScheduleTableBatisMapper scheduleTableBatisMapper;

  public List<ScheduleTableDto> findAllSchedules() {
    return scheduleTableBatisMapper.selectSchedules();
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
      scheduleTableBatisMapper.updateStackMeasurementComplete(stackMeasurementIds);
      scheduleTableBatisMapper.updateScheduleComplete(scheduleIds);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting schedules", e);
    }
  }

  public void removeSchedules(List<Integer> scheduleIds) {
    scheduleRepository.deleteAllById(scheduleIds);
  }
}
