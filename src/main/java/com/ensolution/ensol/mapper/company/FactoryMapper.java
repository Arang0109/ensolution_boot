package com.ensolution.ensol.mapper.company;

import com.ensolution.ensol.dto.entity.company.FactoryDto;
import com.ensolution.ensol.entity.company.Factory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactoryMapper {
  @Mapping(source = "workplace.workplaceId", target = "workplaceId")
  @Mapping(source = "department.departmentId", target = "departmentId")
  FactoryDto toDto(Factory factory);
  @Mapping(source = "workplaceId", target = "workplace.workplaceId")
  @Mapping(source = "departmentId", target = "department.departmentId")
  Factory toEntity(FactoryDto dto);
  List<FactoryDto> toListDto(List<Factory> factories);
}
