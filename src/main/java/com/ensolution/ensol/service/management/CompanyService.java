package com.ensolution.ensol.service.management;

import com.ensolution.ensol.domain.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto findCompanyById(Integer id);
    List<CompanyDto> findAllCompanies();
    Integer addNewCompany(CompanyDto companyDto);
    Integer updateCompany(CompanyDto companyDto);
    Integer removeCompanies(List<CompanyDto> companies);
}
