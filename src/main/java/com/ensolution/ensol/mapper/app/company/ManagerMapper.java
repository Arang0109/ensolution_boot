package com.ensolution.ensol.mapper.app.company;

import com.ensolution.ensol.dto.app.entity.company.ManagerDto;
import com.ensolution.ensol.entity.app.company.Manager;
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
