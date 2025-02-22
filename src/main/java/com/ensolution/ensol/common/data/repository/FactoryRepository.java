package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer> {
}
