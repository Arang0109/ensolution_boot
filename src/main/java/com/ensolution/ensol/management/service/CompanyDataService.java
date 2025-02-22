package com.ensolution.ensol.management.service;

import com.ensolution.ensol.management.data.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyDataService {
  Optional<CompanyDto> findCompanyById(Integer id);
  List<CompanyDto> findAll();
  void saveCompany(CompanyDto companyDto);
  void deleteCompanies(List<Integer> ids);
  boolean existsById(Integer id);
}
