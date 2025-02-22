package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.StackInformationDto;
import com.ensolution.ensol.common.data.entity.StackInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackInformationMapper {
  StackInformationDto toDto(StackInformation stackInformation);
  StackInformation toEntity(StackInformationDto stackInformationDto);
}
