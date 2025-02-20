package com.ensolution.ensol.management.data.mapper;

import com.ensolution.ensol.management.data.dto.company.CompanyDto;
import com.ensolution.ensol.management.data.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
  CompanyDto toDto(Company company);
  Company toEntity(CompanyDto companyDto);
  List<CompanyDto> toDtoList(List<Company> companies);
}
