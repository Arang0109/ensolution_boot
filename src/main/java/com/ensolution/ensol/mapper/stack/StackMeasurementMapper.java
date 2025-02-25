package com.ensolution.ensol.mapper.stack;

import com.ensolution.ensol.dto.entity.stack.StackMeasurementDto;
import com.ensolution.ensol.entity.stack.StackMeasurement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StackMeasurementMapper {
  @Mapping(source = "stack.stackId", target = "stackId")
  @Mapping(source = "pollutant.pollutantId", target = "pollutantId")
  StackMeasurementDto toDto(StackMeasurement stackMeasurement);
  @Mapping(source = "stackId", target = "stack.stackId")
  @Mapping(source = "pollutantId", target = "pollutant.pollutantId")
  StackMeasurement toEntity(StackMeasurementDto stackMeasurementDto);
  List<StackMeasurementDto> toDtoList(List<StackMeasurement> stackMeasurements);
}