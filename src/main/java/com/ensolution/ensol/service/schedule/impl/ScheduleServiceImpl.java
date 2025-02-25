package com.ensolution.ensol.service.schedule.impl;

import com.ensolution.ensol.dto.entity.ScheduleDto;
import com.ensolution.ensol.dto.query.ScheduleTableDto;
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

//  @Override
//  public List<HistoryDto> findAllHistoryOfStacks(Integer stack_id) {
//    return scheduleMapper.selectStackHistory(stack_id);
//  }

//  @Override
//  public List<HistoryDto> historyFormater(List<HistoryDto> histories) {
//    for (HistoryDto history : histories) {
//      StringBuilder pollutants = new StringBuilder();
//      String pollutant_ids = history.getPollutant_ids();
//
//      for (String id : pollutant_ids.split(",")) {
//        String name = pollutantMapper.selectPollutant(Integer.parseInt(id)).getPollutant_name();
//        pollutants.append(name).append(", ");
//      }
//
//      if (!pollutants.isEmpty()) {
//        pollutants.setLength(pollutants.length() - 2);
//      }
//
//      history.setPollutant_ids(pollutants.toString());
//    }
//    return histories;
//  }

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
