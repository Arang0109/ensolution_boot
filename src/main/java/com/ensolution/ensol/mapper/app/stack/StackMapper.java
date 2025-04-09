package com.ensolution.ensol.mapper.app.stack;

import com.ensolution.ensol.dto.app.entity.stack.StackDto;
import com.ensolution.ensol.entity.app.stack.Stack;
import com.ensolution.ensol.mapper.app.company.WorkplaceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WorkplaceMapper.class, StackInformationMapper.class})
public interface StackMapper {
  @Mapping(source = "workplace.workplaceId", target = "workplaceId")
  @Mapping(source = "stackInformation", target = "stackInformation", qualifiedByName = "toDto")
  StackDto toDto(Stack stack);
  @Mapping(source = "workplaceId", target = "workplace.workplaceId")
  @Mapping(source = "stackInformation", target = "stackInformation", qualifiedByName = "toEntity")
  Stack toEntity(StackDto stackDto);
  List<StackDto> toDtoList(List<Stack> stacks);
}
