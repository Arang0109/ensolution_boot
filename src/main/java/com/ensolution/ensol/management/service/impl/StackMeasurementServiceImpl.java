package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.domain.stack.StackMeasurementDto;
import com.ensolution.ensol.management.mapper.StackMeasurementMapper;
import com.ensolution.ensol.management.service.StackMeasurementService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StackMeasurementServiceImpl implements StackMeasurementService {
  private final StackMeasurementMapper stackMeasurementMapper;

  public StackMeasurementServiceImpl(StackMeasurementMapper stackMeasurementMapper) {
    this.stackMeasurementMapper = stackMeasurementMapper;
  }

  @Override
  public StackMeasurementDto findStackMeasurementById(Integer id) {
    return stackMeasurementMapper.selectStackMeasurement(id);
  }

  @Override
  public List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stack_id) {
    return stackMeasurementMapper.selectStackMeasurementsOfStack(stack_id);
  }

  @Override
  public Integer addNewStackMeasurement(StackMeasurementDto stackMeasurementDto) {
    try {
      return stackMeasurementMapper.insert(stackMeasurementDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("StackMeasurement", "ID", stackMeasurementDto.getStack_id().toString(), e);
    }
  }

  @Override
  public Integer removeStackMeasurements(List<StackMeasurementDto> stackMeasurements) {
    if (stackMeasurements == null || stackMeasurements.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (StackMeasurementDto stackMeasurementDto : stackMeasurements) {
      if (stackMeasurementDto == null) {
        throw new IllegalArgumentException("stackMeasurementDto cannot be null");
      }
      ids.add(stackMeasurementDto.getStack_measurement_id());
    }

    try {
      return stackMeasurementMapper.deleteItems(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting stackMeasurements", e);
    }
  }
}
