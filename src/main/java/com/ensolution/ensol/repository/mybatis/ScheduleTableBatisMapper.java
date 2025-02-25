package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.ScheduleTableDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScheduleTableBatisMapper {
  List<ScheduleTableDto> selectSchedules();
  void updateStackMeasurementComplete(@Param("list") List<Integer> stackMeasurementIds);
  void updateScheduleComplete(@Param("list") List<Integer> scheduleIds);
}
