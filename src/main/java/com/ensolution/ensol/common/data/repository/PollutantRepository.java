package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Pollutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollutantRepository extends JpaRepository<Pollutant, Integer> {
}