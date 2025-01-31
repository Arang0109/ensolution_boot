package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.exception.CustomDKException;
import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.mapper.CompanyMapper;
import com.ensolution.ensol.management.service.CompanyService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyMapper companyMapper;

  public CompanyServiceImpl(CompanyMapper companyMapper) {
    this.companyMapper = companyMapper;
  }

  @Override
  public CompanyDto findCompanyById(Integer id) { return companyMapper.selectOne(id); }

  @Override
  public List<CompanyDto> findAllCompanies() {
    return companyMapper.selectAll();
  }

  @Override
  public void createCompany(CompanyDto companyDto) {
    try {
      companyMapper.insert(companyDto);
    } catch (DuplicateKeyException e) {
      throw new CustomDKException("company", "Name", companyDto.getCompany_name(), e);
    }
  }

  @Override
  public void updateCompany(CompanyDto companyDto) {
    CompanyDto existingCompany = companyMapper.selectOne(companyDto.getCompany_id());

    if (existingCompany == null) {
      throw new IllegalArgumentException("Company with Name " + companyDto.getCompany_name() + " does not exist.");
    }

    if (existingCompany.equals(companyDto)) {
      throw new DuplicateKeyException("No changes detected for Company Name: " + companyDto.getCompany_name());
    }

    companyMapper.update(companyDto);
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
      ids.add(companyDto.getCompany_id());
    }

    try {
      companyMapper.deleteItems(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting companies", e);
    }
  }
}
