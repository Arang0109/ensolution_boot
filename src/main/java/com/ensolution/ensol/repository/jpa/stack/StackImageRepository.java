package com.ensolution.ensol.repository.jpa.stack;

import com.ensolution.ensol.entity.stack.StackImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackImageRepository extends JpaRepository<StackImage, Integer> {
}
