package com.ensolution.ensol.service.schedule.impl;

import com.ensolution.ensol.dto.app.entity.ScheduleDto;
import com.ensolution.ensol.dto.app.query.table.ScheduleTableDto;
import com.ensolution.ensol.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
  private final ScheduleDataService scheduleDataService;

  @Override
  public List<ScheduleTableDto> findAllSchedules() {
    return scheduleDataService.findAllSchedules();
  }

  @Override
  public void createSchedule(ScheduleDto scheduleDto) {
    scheduleDataService.createSchedule(scheduleDto);
  }

  @Override
  public void completeSchedules(List<Integer> scheduleIds) {
    scheduleDataService.completeSchedules(scheduleIds);
  }

  @Override
  public void removeSchedules(List<Integer> scheduleIds) {
    scheduleDataService.removeSchedules(scheduleIds);
  }
}
