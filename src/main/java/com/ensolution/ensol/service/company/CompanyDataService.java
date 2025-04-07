package com.ensolution.ensol.service.company;

import com.ensolution.ensol.dto.app.entity.company.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyDataService {
  Optional<CompanyDto> findCompanyById(Integer id);
  List<CompanyDto> findAll();
  void saveCompany(CompanyDto companyDto);
  void updateCompany(CompanyDto companyDto);
  void deleteCompanies(List<Integer> ids);
  boolean existsById(Integer id);
}
