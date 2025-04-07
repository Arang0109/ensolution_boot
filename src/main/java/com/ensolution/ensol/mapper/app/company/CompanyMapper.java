package com.ensolution.ensol.mapper.app.company;

import com.ensolution.ensol.dto.app.entity.company.CompanyDto;
import com.ensolution.ensol.entity.app.company.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
  CompanyDto toDto(Company company);
  Company toEntity(CompanyDto companyDto);
  List<CompanyDto> toDtoList(List<Company> companies);
}
