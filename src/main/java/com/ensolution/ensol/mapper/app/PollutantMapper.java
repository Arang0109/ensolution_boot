package com.ensolution.ensol.mapper.app;

import com.ensolution.ensol.dto.app.entity.PollutantDto;
import com.ensolution.ensol.entity.app.Pollutant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollutantMapper {
  PollutantDto toDto(Pollutant pollutant);
  Pollutant toEntity(PollutantDto pollutantDto);
  List<PollutantDto> toDtoList(List<Pollutant> pollutants);
}