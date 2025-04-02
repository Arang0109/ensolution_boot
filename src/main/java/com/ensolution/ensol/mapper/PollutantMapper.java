package com.ensolution.ensol.mapper;

import com.ensolution.ensol.dto.entity.PollutantDto;
import com.ensolution.ensol.entity.Pollutant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollutantMapper {
  PollutantDto toDto(Pollutant pollutant);
  Pollutant toEntity(PollutantDto pollutantDto);
  List<PollutantDto> toDtoList(List<Pollutant> pollutants);
}