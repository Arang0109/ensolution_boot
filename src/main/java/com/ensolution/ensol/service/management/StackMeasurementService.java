package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.StackMeasurementDto;

import java.util.List;
import java.util.Map;

public interface StackMeasurementService {
  StackMeasurementDto findStackMeasurementById(Integer id);
  List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id);
  Integer addNewStackMeasurement(StackMeasurementDto stackMeasurement);
  Integer removeStackMeasurements(List<StackMeasurementDto> stackMeasurements);
}
