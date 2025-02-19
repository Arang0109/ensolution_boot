package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.entity.Company;
import com.ensolution.ensol.management.repository.CompanyRepository;
import com.ensolution.ensol.management.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;
  private final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public CompanyDto findCompanyById(Integer id) {
    Company company = companyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Company not found"));
    return modelMapper.map(company, CompanyDto.class);
  }

  @Override
  public List<CompanyDto> findAllCompanies() {
    return companyRepository.findAll();
  }

  @Override
  public void createCompany(CompanyDto companyDto) {
    try {
      companyRepository.save(companyDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("company", "Name", companyDto.getName(), e);
    }
  }

  @Override
  public void updateCompany(CompanyDto companyDto) {
    boolean existCompany = companyRepository.existsById(companyDto.getId());

    if (!existCompany) {
      throw new IllegalArgumentException("Company with Name " + companyDto.getName() + " does not exist.");
    }

    companyRepository.save(companyDto);
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
      companyRepository.deleteAllById(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting companies", e);
    }
  }
}
