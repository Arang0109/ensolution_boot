package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.StackInformationDto;
import com.ensolution.ensol.common.data.entity.StackInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StackInformationMapper {
  @Named("toDto")
  StackInformationDto toDto(StackInformation stackInformation);
  @Named("toEntity")
  StackInformation toEntity(StackInformationDto stackInformationDto);
}
