package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.dto.app.entity.ScheduleDto;
import com.ensolution.ensol.dto.app.query.table.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

  void createSchedule(ScheduleDto scheduleDto);

  void completeSchedules(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
