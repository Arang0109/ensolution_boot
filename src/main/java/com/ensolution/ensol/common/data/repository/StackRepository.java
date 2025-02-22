package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Stack;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<Stack, Integer> {
  List<Stack> findByWorkplace_WorkplaceId(Integer workplaceId);
  @EntityGraph(attributePaths = "stackImages")
  Optional<Stack> findWithStackImagesByStackId(Integer stackId);
}
