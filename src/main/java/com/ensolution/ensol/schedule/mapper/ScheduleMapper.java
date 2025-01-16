package com.ensolution.ensol.schedule.mapper;

import com.ensolution.ensol.schedule.domain.HistoryDto;
import com.ensolution.ensol.schedule.domain.ScheduleDto;
import com.ensolution.ensol.schedule.domain.ScheduleTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
  ScheduleDto selectSchedule(Integer schedule_id);
  List<ScheduleTableDto> selectAll();
  List<HistoryDto> selectStackHistory(Integer stack_id);
  Integer insert(ScheduleDto schedule);
  Integer deleteItems(List<Integer> schedule_ids);
  Integer updateComplete(List<Integer> schedule_ids);
}
