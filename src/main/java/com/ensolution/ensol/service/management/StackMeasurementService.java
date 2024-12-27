package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.management.stack.StackMeasurementDto;

import java.util.List;

public interface StackMeasurementService {
  StackMeasurementDto findStackMeasurementById(Integer id);
  List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id);
  Integer addNewStackMeasurement(StackMeasurementDto stackMeasurement);
  Integer removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
