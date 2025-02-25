package com.ensolution.ensol.repository.jpa.company;

import com.ensolution.ensol.entity.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
