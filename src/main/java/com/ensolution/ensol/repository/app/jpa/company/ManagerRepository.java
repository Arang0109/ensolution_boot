package com.ensolution.ensol.repository.app.jpa.company;

import com.ensolution.ensol.entity.app.company.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
