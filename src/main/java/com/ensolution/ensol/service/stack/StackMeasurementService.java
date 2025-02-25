package com.ensolution.ensol.service.stack;

import com.ensolution.ensol.dto.entity.stack.StackMeasurementDto;
import com.ensolution.ensol.dto.query.table.StackMeasurementTableDto;

import java.util.List;
import java.util.Optional;

public interface StackMeasurementService {
  Optional<StackMeasurementDto> findStackMeasurementById(Integer id);
  List<StackMeasurementTableDto> findStackMeasurementsByStackId(Integer stack_id);
  void createStackMeasurement(StackMeasurementDto stackMeasurement);
  void removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
