package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.company.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    CompanyDto findCompanyById(Integer id);
    List<CompanyDto> findAllCompanies();
    void createCompany(CompanyDto companyDto);
    void updateCompany(CompanyDto companyDto);
    void removeCompanies(List<CompanyDto> companies);
}
