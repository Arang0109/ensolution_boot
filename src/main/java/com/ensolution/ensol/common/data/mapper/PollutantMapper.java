package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.PollutantDto;
import com.ensolution.ensol.common.data.entity.Pollutant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollutantMapper {
  PollutantDto toDto(Pollutant pollutant);
  Pollutant toEntity(PollutantDto pollutantDto);
  List<PollutantDto> toDtoList(List<Pollutant> pollutants);
}
