package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.domain.schedule.HistoryDto;
import com.ensolution.ensol.domain.schedule.ScheduleDto;
import com.ensolution.ensol.domain.schedule.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

  List<HistoryDto> findAllHistoryOfStacks(Integer stack_id);

  List<HistoryDto> historyFormater(List<HistoryDto> histories);

  void addNewSchedule(ScheduleDto scheduleDto);

  void updateScheduleComplete(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
