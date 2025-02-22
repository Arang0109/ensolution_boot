package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.StackMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackMeasurementRepository extends JpaRepository<StackMeasurement, Integer> {
}
