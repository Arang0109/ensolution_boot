package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.stack.StackMeasurementDto;

import java.util.List;

public interface StackMeasurementService {
  StackMeasurementDto findStackMeasurementById(Integer id);
  List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id);
  Integer addNewStackMeasurement(StackMeasurementDto stackMeasurement);
  Integer removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
