package com.ensolution.ensol.service;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.mapper.CompanyMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
  private final CompanyMapper companyMapper;

  public CompanyService(CompanyMapper companyMapper) {
    this.companyMapper = companyMapper;
  }

  public CompanyDto getCompanyInformation(Integer id) {
    return companyMapper.selectOne(id);
  }
  public List<CompanyDto> getAllCompany() {
    return companyMapper.selectAll();
  }
  public Integer addCompany(CompanyDto companyDto) {
    try {
      return companyMapper.insert(companyDto);
    } catch (DuplicateKeyException e) {
      throw new DuplicateKeyException(e.getMessage());
    }
  }
}
