package com.ensolution.ensol.mapper.app;

import com.ensolution.ensol.dto.app.entity.TeamDto;
import com.ensolution.ensol.entity.app.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
  TeamDto toDto(Team team);
  Team toEntity(TeamDto teamDto);
  List<TeamDto> toDtoList(List<Team> teams);
}
