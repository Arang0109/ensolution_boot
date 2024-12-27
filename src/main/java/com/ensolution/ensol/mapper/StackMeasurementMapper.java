package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.management.stack.StackMeasurementDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StackMeasurementMapper {
  StackMeasurementDto selectStackMeasurement(Integer stack_measurement_id);
  List<StackMeasurementDto> selectStackMeasurementsOfStack(Integer stack_id);
  Integer insert(StackMeasurementDto stackMeasurement);
  Integer deleteItems(List<Integer> ids);
  void updateComplete(List<Integer> stack_measurement_ids);
  void updateNonComplete(List<Integer> stack_measurement_ids);
}
