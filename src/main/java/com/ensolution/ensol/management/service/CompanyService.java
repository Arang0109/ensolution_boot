package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.domain.company.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto findCompanyById(Integer id);
    List<CompanyDto> findAllCompanies();
    Integer addNewCompany(CompanyDto companyDto);
    Integer updateCompany(CompanyDto companyDto);
    Integer removeCompanies(List<CompanyDto> companies);
}
