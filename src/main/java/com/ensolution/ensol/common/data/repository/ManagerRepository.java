package com.ensolution.ensol.common.data.repository;

import com.ensolution.ensol.common.data.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
