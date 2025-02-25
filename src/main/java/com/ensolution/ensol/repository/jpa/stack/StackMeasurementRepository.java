package com.ensolution.ensol.repository.jpa.stack;

import com.ensolution.ensol.entity.stack.Stack;
import com.ensolution.ensol.entity.stack.StackMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackMeasurementRepository extends JpaRepository<StackMeasurement, Integer> {
  List<StackMeasurement> findStackMeasurementsByStack(Stack stack);
}
