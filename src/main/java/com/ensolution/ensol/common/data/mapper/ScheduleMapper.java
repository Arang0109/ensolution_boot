package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.ScheduleDto;
import com.ensolution.ensol.common.data.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
  @Mapping(source = "stackMeasurement.stackMeasurementId", target = "stackMeasurementId")
  @Mapping(source = "team.teamId", target = "teamId")
  ScheduleDto toDto(Schedule schedule);
  @Mapping(source = "stackMeasurementId", target = "stackMeasurement.stackMeasurementId")
  @Mapping(source = "teamId", target = "team.teamId")
  Schedule toEntity(ScheduleDto scheduleDto);
}
