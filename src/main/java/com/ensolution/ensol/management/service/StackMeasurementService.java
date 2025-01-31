package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.stack.StackMeasurementDto;

import java.util.List;

public interface StackMeasurementService {
  StackMeasurementDto findStackMeasurementById(Integer id);
  List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id);
  void createStackMeasurement(StackMeasurementDto stackMeasurement);
  void removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
