package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.CompanyDto;
import com.ensolution.ensol.common.data.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
  CompanyDto toDto(Company company);
  Company toEntity(CompanyDto companyDto);
  List<CompanyDto> toDtoList(List<Company> companies);
}
