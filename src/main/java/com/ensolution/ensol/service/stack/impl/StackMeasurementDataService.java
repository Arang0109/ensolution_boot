package com.ensolution.ensol.service.stack.impl;

import com.ensolution.ensol.dto.entity.stack.StackMeasurementDto;
import com.ensolution.ensol.dto.query.StackMeasurementsOfStackDto;
import com.ensolution.ensol.entity.stack.StackMeasurement;
import com.ensolution.ensol.mapper.stack.StackMeasurementMapper;
import com.ensolution.ensol.repository.mybatis.TableBatisMapper;
import com.ensolution.ensol.repository.jpa.stack.StackMeasurementRepository;
import com.ensolution.ensol.common.exception.CustomDKException;
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
  private final TableBatisMapper tableBatisMapper;

  public Optional<StackMeasurementDto> findStackMeasurementById(Integer stackMeasurementId) {
    Optional<StackMeasurement> stackMeasurement = stackMeasurementRepository.findById(stackMeasurementId);
    return stackMeasurement.map(stackMeasurementMapper::toDto);
  }

  public List<StackMeasurementsOfStackDto> findStackMeasurementsByStackId(Integer stackId) {
    return tableBatisMapper.stackMeasurementsOfStack(stackId);
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
