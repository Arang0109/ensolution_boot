package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.FactoryDto;
import com.ensolution.ensol.common.data.entity.Factory;
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
