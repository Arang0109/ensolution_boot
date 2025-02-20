package com.ensolution.ensol.management.data.repository;

import com.ensolution.ensol.management.data.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
  List<Workplace> findByCompany_CompanyId(Integer companyId);
}
