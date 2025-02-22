package com.ensolution.ensol.management.data.repository;

import com.ensolution.ensol.management.data.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
