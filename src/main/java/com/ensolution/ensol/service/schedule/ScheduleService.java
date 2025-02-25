package com.ensolution.ensol.service.schedule;

import com.ensolution.ensol.dto.entity.ScheduleDto;
import com.ensolution.ensol.dto.query.table.ScheduleTableDto;

import java.util.List;

public interface ScheduleService {
  List<ScheduleTableDto> findAllSchedules();

//  List<HistoryDto> findAllHistoryOfStacks(Integer stack_id);
//
//  List<HistoryDto> historyFormater(List<HistoryDto> histories);

  void createSchedule(ScheduleDto scheduleDto);

  void completeSchedules(List<Integer> schedule_ids);

  void removeSchedules(List<Integer> schedule_ids);
}
