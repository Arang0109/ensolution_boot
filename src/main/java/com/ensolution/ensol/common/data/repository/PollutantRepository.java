package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Pollutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollutantRepository extends JpaRepository<Pollutant, Integer> {
  Optional<Pollutant> findByPollutantNameKR(String pollutantName);
}