package com.ensolution.ensol.domain;

import java.util.Objects;

public class TeamDto {
  private Integer team_id;
  private String team_name;

  public TeamDto() {
  }

  public TeamDto(Integer team_id, String team_name) {
    this.team_id = team_id;
    this.team_name = team_name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TeamDto teamDto = (TeamDto) o;
    return Objects.equals(team_id, teamDto.team_id) && Objects.equals(team_name, teamDto.team_name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(team_id, team_name);
  }

  public Integer getTeam_id() {
    return team_id;
  }

  public void setTeam_id(Integer team_id) {
    this.team_id = team_id;
  }

  public String getTeam_name() {
    return team_name;
  }

  public void setTeam_name(String team_name) {
    this.team_name = team_name;
  }

  @Override
  public String toString() {
    return "TeamDto{" +
        "team_id=" + team_id +
        ", team_name='" + team_name + '\'' +
        '}';
  }
}