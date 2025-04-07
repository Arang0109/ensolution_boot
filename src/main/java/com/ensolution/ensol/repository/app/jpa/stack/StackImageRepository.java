package com.ensolution.ensol.repository.app.jpa.stack;

import com.ensolution.ensol.entity.app.stack.StackImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackImageRepository extends JpaRepository<StackImage, Integer> {
}
