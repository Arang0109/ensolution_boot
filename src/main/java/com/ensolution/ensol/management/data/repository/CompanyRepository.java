package com.ensolution.ensol.management.data.repository;

import com.ensolution.ensol.management.data.dto.company.CompanyDto;
import com.ensolution.ensol.management.data.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
