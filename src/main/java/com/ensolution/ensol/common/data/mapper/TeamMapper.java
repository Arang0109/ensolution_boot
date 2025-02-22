package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.TeamDto;
import com.ensolution.ensol.common.data.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
  TeamDto toDto(Team team);
  Team toEntity(TeamDto teamDto);
  List<TeamDto> toDtoList(List<Team> teams);
}
