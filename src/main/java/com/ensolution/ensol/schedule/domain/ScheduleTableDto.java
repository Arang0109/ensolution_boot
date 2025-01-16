package com.ensolution.ensol.schedule.domain;

import java.sql.Date;
import java.util.Objects;

public class ScheduleTableDto {
  private String schedule_ids;
  private Integer team_id;
  private String stack_measurement_ids;
  private String workplace_name;
  private String stack_name;
  private Integer stack_id;
  private String pollutants;
  private String pollutant_ids;
  private String team_name;
  private Date measure_date;
  private Boolean is_completed;

  public ScheduleTableDto() {}

  public ScheduleTableDto(String schedule_ids, Integer team_id, String stack_measurement_ids,
                          String workplace_name, String stack_name, String pollutants, String pollutant_ids,
                          String team_name, Integer stack_id, Date measure_date, Boolean is_completed) {
    this.schedule_ids = schedule_ids;
    this.team_id = team_id;
    this.stack_measurement_ids = stack_measurement_ids;
    this.workplace_name = workplace_name;
    this.stack_name = stack_name;
    this.stack_id = stack_id;
    this.pollutants = pollutants;
    this.pollutant_ids = pollutant_ids;
    this.team_name = team_name;
    this.measure_date = measure_date;
    this.is_completed = is_completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ScheduleTableDto that = (ScheduleTableDto) o;
    return Objects.equals(stack_id, that.stack_id) && Objects.equals(measure_date, that.measure_date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stack_id, measure_date);
  }

  public String getSchedule_ids() {
    return schedule_ids;
  }

  public void setSchedule_ids(String schedule_ids) {
    this.schedule_ids = schedule_ids;
  }

  public Integer getTeam_id() {
    return team_id;
  }

  public void setTeam_id(Integer team_id) {
    this.team_id = team_id;
  }

  public String getStack_measurement_ids() {
    return stack_measurement_ids;
  }

  public void setStack_measurement_ids(String stack_measurement_ids) {
    this.stack_measurement_ids = stack_measurement_ids;
  }

  public String getWorkplace_name() {
    return workplace_name;
  }

  public void setWorkplace_name(String workplace_name) {
    this.workplace_name = workplace_name;
  }

  public String getStack_name() {
    return stack_name;
  }

  public void setStack_name(String stack_name) {
    this.stack_name = stack_name;
  }

  public Integer getStack_id() {
    return stack_id;
  }

  public void setStack_id(Integer stack_id) {
    this.stack_id = stack_id;
  }

  public String getPollutants() {
    return pollutants;
  }

  public void setPollutants(String pollutants) {
    this.pollutants = pollutants;
  }

  public String getPollutant_ids() {
    return pollutant_ids;
  }

  public void setPollutant_ids(String pollutant_ids) {
    this.pollutant_ids = pollutant_ids;
  }

  public String getTeam_name() {
    return team_name;
  }

  public void setTeam_name(String team_name) {
    this.team_name = team_name;
  }

  public Date getMeasure_date() {
    return measure_date;
  }

  public void setMeasure_date(Date measure_date) {
    this.measure_date = measure_date;
  }

  public Boolean getIs_completed() {
    return is_completed;
  }

  public void setIs_completed(Boolean is_completed) {
    this.is_completed = is_completed;
  }

  @Override
  public String toString() {
    return "ScheduleTableDto{" +
        "schedule_ids='" + schedule_ids + '\'' +
        ", team_id=" + team_id +
        ", stack_measurement_ids='" + stack_measurement_ids + '\'' +
        ", workplace_name='" + workplace_name + '\'' +
        ", stack_name='" + stack_name + '\'' +
        ", stack_id=" + stack_id +
        ", pollutants='" + pollutants + '\'' +
        ", pollutant_ids='" + pollutant_ids + '\'' +
        ", team_name='" + team_name + '\'' +
        ", measure_date=" + measure_date +
        ", is_completed=" + is_completed +
        '}';
  }
}