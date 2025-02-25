package com.ensolution.ensol.mapper;

import com.ensolution.ensol.dto.entity.TeamDto;
import com.ensolution.ensol.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
  TeamDto toDto(Team team);
  Team toEntity(TeamDto teamDto);
  List<TeamDto> toDtoList(List<Team> teams);
}
