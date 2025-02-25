package com.ensolution.ensol.dto.query;

import java.sql.Date;

public class HistoryDto {
  private Date measure_date;
  private Integer stack_id;
  private Integer team_id;
  private String team_name;
  private String pollutant_ids;

  public HistoryDto() {}

  public HistoryDto(Date measure_date, Integer stack_id, Integer team_id, String team_name, String pollutant_ids) {
    this.measure_date = measure_date;
    this.stack_id = stack_id;
    this.team_id = team_id;
    this.team_name = team_name;
    this.pollutant_ids = pollutant_ids;
  }

  public Date getMeasure_date() {
    return measure_date;
  }

  public void setMeasure_date(Date measure_date) {
    this.measure_date = measure_date;
  }

  public Integer getStack_id() {
    return stack_id;
  }

  public void setStack_id(Integer stack_id) {
    this.stack_id = stack_id;
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

  public String getPollutant_ids() {
    return pollutant_ids;
  }

  public void setPollutant_ids(String pollutant_ids) {
    this.pollutant_ids = pollutant_ids;
  }

  @Override
  public String toString() {
    return "HistoryDto{" +
        "measure_date=" + measure_date +
        ", stack_id=" + stack_id +
        ", team_id=" + team_id +
        ", team_name='" + team_name + '\'' +
        ", pollutant_ids=" + pollutant_ids +
        '}';
  }
}
