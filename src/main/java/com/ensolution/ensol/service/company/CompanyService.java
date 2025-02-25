package com.ensolution.ensol.service.company;

import com.ensolution.ensol.dto.entity.company.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyDto> findCompanyById(Integer id);
    List<CompanyDto> findAllCompanies();
    void createCompany(CompanyDto companyDto);
    void updateCompany(CompanyDto companyDto);
    void removeCompanies(List<CompanyDto> companies);
}
