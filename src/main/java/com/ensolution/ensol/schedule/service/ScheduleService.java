package com.ensolution.ensol.schedule.service;

import com.ensolution.ensol.schedule.domain.HistoryDto;
import com.ensolution.ensol.schedule.domain.ScheduleDto;
import com.ensolution.ensol.schedule.domain.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

  List<HistoryDto> findAllHistoryOfStacks(Integer stack_id);

  List<HistoryDto> historyFormater(List<HistoryDto> histories);

  void addNewSchedule(ScheduleDto scheduleDto);

  void completeSchedules(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
