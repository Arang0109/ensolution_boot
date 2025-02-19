package com.ensolution.ensol.management.repository;

import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
  Optional<CompanyDto> findByName(String name);
}
