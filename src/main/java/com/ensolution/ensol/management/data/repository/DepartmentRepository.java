package com.ensolution.ensol.management.data.repository;

import com.ensolution.ensol.management.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
