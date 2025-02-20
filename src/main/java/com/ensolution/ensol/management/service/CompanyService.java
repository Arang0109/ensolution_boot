package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.data.dto.company.CompanyDto;
import com.ensolution.ensol.management.data.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyDto> findCompanyById(Integer id);
    List<CompanyDto> findAllCompanies();
    void createCompany(CompanyDto companyDto);
    void updateCompany(CompanyDto companyDto);
    void removeCompanies(List<CompanyDto> companies);
}
