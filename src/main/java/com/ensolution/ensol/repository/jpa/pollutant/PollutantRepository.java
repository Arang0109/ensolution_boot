package com.ensolution.ensol.repository.jpa.pollutant;

import com.ensolution.ensol.entity.Pollutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollutantRepository extends JpaRepository<Pollutant, Integer> {
  Optional<Pollutant> findByPollutantNameKR(String pollutantName);
}