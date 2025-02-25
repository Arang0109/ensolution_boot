package com.ensolution.ensol.repository.jpa.stack;

import com.ensolution.ensol.entity.stack.StackInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackInformationRepository extends JpaRepository<StackInformation, Integer> {
}
