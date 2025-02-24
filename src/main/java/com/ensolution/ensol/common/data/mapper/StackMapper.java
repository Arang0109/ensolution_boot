package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.StackDto;
import com.ensolution.ensol.common.data.entity.Stack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WorkplaceMapper.class, StackInformationMapper.class})
public interface StackMapper {
  @Mapping(source = "workplace.workplaceId", target = "workplaceId")
  @Mapping(source = "factory.factoryId", target = "factoryId")
  @Mapping(source = "stackInformation", target = "stackInformation", qualifiedByName = "toDto")
  StackDto toDto(Stack stack);
  @Mapping(source = "workplaceId", target = "workplace.workplaceId")
  @Mapping(source = "factoryId", target = "factory.factoryId")
  @Mapping(source = "stackInformation", target = "stackInformation", qualifiedByName = "toEntity")
  Stack toEntity(StackDto stackDto);
  List<StackDto> toDtoList(List<Stack> stacks);
}
