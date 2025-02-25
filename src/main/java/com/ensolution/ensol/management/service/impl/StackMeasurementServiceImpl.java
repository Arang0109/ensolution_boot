package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.dto.stack.StackMeasurementsOfStackDto;
import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.service.StackMeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StackMeasurementServiceImpl implements StackMeasurementService {
  private final StackMeasurementDataService stackMeasurementDataService;

  @Override
  public Optional<StackMeasurementDto> findStackMeasurementById(Integer stackMeasurementId) {
   return stackMeasurementDataService.findStackMeasurementById(stackMeasurementId);
  }

  @Override
  public List<StackMeasurementsOfStackDto> findStackMeasurementsByStackId(Integer stackId) {;
    return stackMeasurementDataService.findStackMeasurementsByStackId(stackId);
  }

  @Override
  public void createStackMeasurement(StackMeasurementDto stackMeasurementDto) {
    try {
      stackMeasurementDataService.createStackMeasurement(stackMeasurementDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("StackMeasurement", "ID", stackMeasurementDto.getStackId().toString(), e);
    }
  }

  @Override
  public void removeStackMeasurements(List<StackMeasurementDto> stackMeasurements) {
    if (stackMeasurements == null || stackMeasurements.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (StackMeasurementDto stackMeasurementDto : stackMeasurements) {
      if (stackMeasurementDto == null) {
        throw new IllegalArgumentException("stackMeasurementDto cannot be null");
      }
      ids.add(stackMeasurementDto.getStackMeasurementId());
    }

    stackMeasurementDataService.removeStackMeasurements(ids);
  }
}
