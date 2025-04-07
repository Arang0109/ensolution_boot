package com.ensolution.ensol.repository.app.jpa.stack;

import com.ensolution.ensol.entity.app.stack.Stack;
import com.ensolution.ensol.entity.app.stack.StackMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackMeasurementRepository extends JpaRepository<StackMeasurement, Integer> {
  List<StackMeasurement> findStackMeasurementsByStack(Stack stack);
}
