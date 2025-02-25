package com.ensolution.ensol.mapper.stack;

import com.ensolution.ensol.dto.entity.stack.StackInformationDto;
import com.ensolution.ensol.entity.stack.StackInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StackInformationMapper {
  @Named("toDto")
  StackInformationDto toDto(StackInformation stackInformation);
  @Named("toEntity")
  StackInformation toEntity(StackInformationDto stackInformationDto);
}
