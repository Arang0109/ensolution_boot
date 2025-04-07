package com.ensolution.ensol.repository.app.mybatis;

import com.ensolution.ensol.dto.app.query.table.ScheduleTableDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScheduleTableMapper {
  List<ScheduleTableDto> selectSchedules();
  void updateStackMeasurementComplete(@Param("list") List<Integer> stackMeasurementIds);
  void updateScheduleComplete(@Param("list") List<Integer> scheduleIds);
}
