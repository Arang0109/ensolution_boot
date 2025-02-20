package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.data.dto.company.CompanyDto;
import com.ensolution.ensol.management.service.CompanyDataService;
import com.ensolution.ensol.management.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyDataService companyDataService;

  @Autowired
  public CompanyServiceImpl(CompanyDataService companyDataService) {
    this.companyDataService = companyDataService;
  }

  @Override
  public Optional<CompanyDto> findCompanyById(Integer id) {
    return companyDataService.findCompanyById(id);
  }

  @Override
  public List<CompanyDto> findAllCompanies() {
    return companyDataService.findAll();
  }

  @Override
  public void createCompany(CompanyDto companyDto) {
    try {
      companyDataService.saveCompany(companyDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("company", "Name", companyDto.getName(), e);
    }
  }

  @Override
  public void updateCompany(CompanyDto companyDto) {
    if (!companyDataService.existsById(companyDto.getId())) {
      throw new IllegalArgumentException("Company with Name " + companyDto.getName() + " does not exist.");
    }
    companyDataService.saveCompany(companyDto);
  }

  @Override
  public void removeCompanies(List<CompanyDto> companies) {
    if (companies == null || companies.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty");
    }

    List<Integer> ids = new ArrayList<>();

    for (CompanyDto companyDto : companies) {
      if (companyDto == null) {
        throw new IllegalArgumentException("CompanyDto cannot be null");
      }
      ids.add(companyDto.getId());
    }

    try {
      companyDataService.deleteCompanies(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting companies", e);
    }
  }
}
