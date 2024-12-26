package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.domain.HistoryDto;
import com.ensolution.ensol.domain.ScheduleDto;
import com.ensolution.ensol.domain.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

  List<HistoryDto> findAllHistoryOfStacks(Integer stack_id);

  void addNewSchedule(ScheduleDto scheduleDto);

  void updateScheduleComplete(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
