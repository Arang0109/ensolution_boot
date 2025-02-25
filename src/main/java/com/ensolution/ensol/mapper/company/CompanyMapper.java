package com.ensolution.ensol.mapper.company;

import com.ensolution.ensol.dto.entity.company.CompanyDto;
import com.ensolution.ensol.entity.company.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
  CompanyDto toDto(Company company);
  Company toEntity(CompanyDto companyDto);
  List<CompanyDto> toDtoList(List<Company> companies);
}
