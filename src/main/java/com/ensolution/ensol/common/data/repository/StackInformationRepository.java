package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.StackInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackInformationRepository extends JpaRepository<StackInformation, Integer> {
}
