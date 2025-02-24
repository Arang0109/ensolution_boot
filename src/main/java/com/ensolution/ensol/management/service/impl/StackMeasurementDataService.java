package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.StackDto;
import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.entity.Stack;
import com.ensolution.ensol.common.data.entity.StackMeasurement;
import com.ensolution.ensol.common.data.mapper.StackMapper;
import com.ensolution.ensol.common.data.mapper.StackMeasurementMapper;
import com.ensolution.ensol.common.data.repository.StackMeasurementRepository;
import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.service.StackDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StackMeasurementDataService {
  private final StackMeasurementMapper stackMeasurementMapper;
  private final StackMeasurementRepository stackMeasurementRepository;
  private final StackDataService stackDataService;
  private final StackMapper stackMapper;

  public Optional<StackMeasurementDto> findStackMeasurementById(Integer stackMeasurementId) {
    Optional<StackMeasurement> stackMeasurement = stackMeasurementRepository.findById(stackMeasurementId);
    return stackMeasurement.map(stackMeasurementMapper::toDto);
  }

  public List<StackMeasurementDto> findStackMeasurementsByStackId(Integer stackId) {
    StackDto stackDto = stackDataService.findStackById(stackId);
    Stack stack = stackMapper.toEntity(stackDto);
    return stackMeasurementMapper.toDtoList(
        stackMeasurementRepository.findStackMeasurementsByStack(stack)
    );
  }

  public void createStackMeasurement(StackMeasurementDto stackMeasurementDto) {
    try {
      StackMeasurement stackMeasurement = stackMeasurementMapper.toEntity(stackMeasurementDto);
      stackMeasurementRepository.save(stackMeasurement);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("StackMeasurement", "ID", stackMeasurementDto.getStackId().toString(), e);
    }
  }

  public void removeStackMeasurements(List<Integer> ids) {
    try {
      stackMeasurementRepository.deleteAllById(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting stackMeasurements", e);
    }
  }
}
