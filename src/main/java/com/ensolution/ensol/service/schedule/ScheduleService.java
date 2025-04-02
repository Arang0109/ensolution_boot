package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.dto.entity.ScheduleDto;
import com.ensolution.ensol.dto.query.HistoryDto;
import com.ensolution.ensol.dto.query.table.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

  void createSchedule(ScheduleDto scheduleDto);

  void completeSchedules(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
