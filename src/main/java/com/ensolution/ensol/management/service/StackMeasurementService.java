package com.ensolution.ensol.management.service;

import com.ensolution.ensol.common.data.dto.StackMeasurementDto;

import java.util.List;
import java.util.Optional;

public interface StackMeasurementService {
  Optional<StackMeasurementDto> findStackMeasurementById(Integer id);
  List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id);
  void createStackMeasurement(StackMeasurementDto stackMeasurement);
  void removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
