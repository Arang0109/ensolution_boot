package com.ensolution.ensol.mapper.company;

import com.ensolution.ensol.dto.entity.company.ManagerDto;
import com.ensolution.ensol.entity.company.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
  @Mapping(source = "factory.factoryId", target = "factoryId")
  ManagerDto toDto(Manager manager);
  @Mapping(source = "factoryId", target = "factory.factoryId")
  Manager toEntity(ManagerDto dto);
  List<ManagerDto> toDtoList(List<Manager> managers);
}
