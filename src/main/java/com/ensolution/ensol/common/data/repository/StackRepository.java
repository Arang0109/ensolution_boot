package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Integer> {
}
