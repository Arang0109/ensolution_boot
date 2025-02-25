package com.ensolution.ensol.repository.jpa.company;

import com.ensolution.ensol.entity.company.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer> {
}
