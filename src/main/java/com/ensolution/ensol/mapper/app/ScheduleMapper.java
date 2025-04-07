package com.ensolution.ensol.mapper.app;

import com.ensolution.ensol.dto.app.entity.ScheduleDto;
import com.ensolution.ensol.entity.app.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
  @Mapping(source = "stackMeasurement.stackMeasurementId", target = "stackMeasurementId")
  @Mapping(source = "team.teamId", target = "teamId")
  ScheduleDto toDto(Schedule schedule);
  @Mapping(source = "stackMeasurementId", target = "stackMeasurement.stackMeasurementId")
  @Mapping(source = "teamId", target = "team.teamId")
  Schedule toEntity(ScheduleDto scheduleDto);

  default List<ScheduleDto> toDtoList(List<Schedule> schedules) {
    return schedules.stream().map(this::toDto).collect(Collectors.toList());
  }
}
