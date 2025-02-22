package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Stack;
import com.ensolution.ensol.common.data.entity.StackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackImageRepository extends JpaRepository<StackImage, Integer> {
}
