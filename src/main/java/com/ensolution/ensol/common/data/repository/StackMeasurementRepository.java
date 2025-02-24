package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.entity.Stack;
import com.ensolution.ensol.common.data.entity.StackMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackMeasurementRepository extends JpaRepository<StackMeasurement, Integer> {
  List<StackMeasurement> findStackMeasurementsByStack(Stack stack);
}
