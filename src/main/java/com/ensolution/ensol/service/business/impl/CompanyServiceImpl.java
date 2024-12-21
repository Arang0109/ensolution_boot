package com.ensolution.ensol.service.business.impl;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.mapper.CompanyMapper;
import com.ensolution.ensol.service.business.CompanyService;
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
  public CompanyDto findCompanyById(Integer id) {
    return companyMapper.selectOne(id);
  }

  @Override
  public List<CompanyDto> findAllCompanies() {
    return companyMapper.selectAll();
  }

  @Override
  public Integer addNewCompany(CompanyDto companyDto) {
    try {
      return companyMapper.insert(companyDto);
    } catch (DuplicateKeyException e) {
      throw new DuplicateKeyException("Failed to add company. Duplicate key for ID: " + companyDto.getCompany_id(), e);
    }
  }

  @Override
  public Integer updateCompany(CompanyDto companyDto) {
    CompanyDto existingCompany = companyMapper.selectOne(companyDto.getCompany_id());

    if (existingCompany == null) {
      throw new IllegalArgumentException("Company with ID " + companyDto.getCompany_id() + " does not exist.");
    }

    if (existingCompany.equals(companyDto)) {
      System.out.println("No changes detected for Company ID: " + companyDto.getCompany_id());
      return 0;
    }

    return companyMapper.update(companyDto);
  }

  @Override
  public Integer removeCompanies(List<CompanyDto> companies) {
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
      return companyMapper.delete(ids);
    } catch (DataAccessException e) {
      throw new RuntimeException("Database error occurred while deleting companies", e);
    }
  }
}
