package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.CompanyDto;
import com.ensolution.ensol.common.data.entity.Company;
import com.ensolution.ensol.common.data.mapper.CompanyMapper;
import com.ensolution.ensol.common.data.repository.CompanyRepository;
import com.ensolution.ensol.management.service.CompanyDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyDataServiceImpl implements CompanyDataService {
  private final CompanyRepository companyRepository;
  private final CompanyMapper companyMapper;

  @Override
  public Optional<CompanyDto> findCompanyById(Integer id) {
    return companyRepository.findById(id).map(companyMapper::toDto);
  }

  @Override
  public List<CompanyDto> findAll() {
    List<Company> companies = companyRepository.findAll();
    return companyMapper.toDtoList(companies);
  }

  @Override
  @Transactional
  public void saveCompany(CompanyDto companyDto) {
    companyRepository.save(companyMapper.toEntity(companyDto));
  }

  @Override
  @Transactional
  public void updateCompany(CompanyDto companyDto) {
    Company company = companyRepository.findById(companyDto.getCompanyId())
        .orElseThrow(() -> new RuntimeException("Company not found"));

    if (companyDto.getCompanyName() != null) {
      company.setCompanyName(companyDto.getCompanyName());
    }

    if (companyDto.getAddress() != null) {
      company.setAddress(companyDto.getAddress());
    }

    if (companyDto.getBizNumber() != null) {
      company.setBizNumber(companyDto.getBizNumber());
    }

    if (companyDto.getCeoName() != null) {
      company.setCeoName(companyDto.getCeoName());
    }
  }

  @Override
  @Transactional
  public void deleteCompanies(List<Integer> ids) {
    companyRepository.deleteAllById(ids);
  }

  @Override
  public boolean existsById(Integer id) {
    return companyRepository.existsById(id);
  }
}
