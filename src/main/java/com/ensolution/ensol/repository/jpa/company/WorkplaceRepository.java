package com.ensolution.ensol.repository.jpa.company;

import com.ensolution.ensol.entity.company.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
  List<Workplace> findByCompany_CompanyId(Integer companyId);
}
