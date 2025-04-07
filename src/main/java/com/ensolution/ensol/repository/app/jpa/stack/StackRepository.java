package com.ensolution.ensol.repository.app.jpa.stack;

import com.ensolution.ensol.entity.app.stack.Stack;
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
  Optional<Stack> findByStackName(String stackName);
}
