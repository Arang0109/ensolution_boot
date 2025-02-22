package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
