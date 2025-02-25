package com.ensolution.ensol.management.service;

import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.dto.stack.StackMeasurementsOfStackDto;

import java.util.List;
import java.util.Optional;

public interface StackMeasurementService {
  Optional<StackMeasurementDto> findStackMeasurementById(Integer id);
  List<StackMeasurementsOfStackDto> findStackMeasurementsByStackId(Integer stack_id);
  void createStackMeasurement(StackMeasurementDto stackMeasurement);
  void removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
