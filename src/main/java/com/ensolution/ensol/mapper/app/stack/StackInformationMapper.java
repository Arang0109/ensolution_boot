package com.ensolution.ensol.mapper.app.stack;

import com.ensolution.ensol.dto.app.entity.stack.StackInformationDto;
import com.ensolution.ensol.entity.app.stack.StackInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StackInformationMapper {
  @Named("toDto")
  StackInformationDto toDto(StackInformation stackInformation);
  @Named("toEntity")
  StackInformation toEntity(StackInformationDto stackInformationDto);
}
