package com.ensolution.ensol.schedule.domain;

import java.sql.Date;
import java.util.Objects;

public class ScheduleDto {
  private Integer schedule_id;
  private Integer team_id;
  private Integer stack_measurement_id;
  private Date measure_date;
  private Boolean is_completed;

  public ScheduleDto() {}

  public ScheduleDto(Integer schedule_id, Integer team_id, Integer stack_measurement_id, Date measure_date, Boolean is_completed) {
    this.schedule_id = schedule_id;
    this.team_id = team_id;
    this.stack_measurement_id = stack_measurement_id;
    this.measure_date = measure_date;
    this.is_completed = is_completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ScheduleDto that = (ScheduleDto) o;
    return Objects.equals(schedule_id, that.schedule_id) && Objects.equals(team_id, that.team_id) && Objects.equals(stack_measurement_id, that.stack_measurement_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schedule_id, team_id, stack_measurement_id);
  }

  public Integer getSchedule_id() {
    return schedule_id;
  }

  public void setSchedule_id(Integer schedule_id) {
    this.schedule_id = schedule_id;
  }

  public Integer getTeam_id() {
    return team_id;
  }

  public void setTeam_id(Integer team_id) {
    this.team_id = team_id;
  }

  public Integer getStack_measurement_id() {
    return stack_measurement_id;
  }

  public void setStack_measurement_id(Integer stack_measurement_id) {
    this.stack_measurement_id = stack_measurement_id;
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
    return "ScheduleDto{" +
        "schedule_id=" + schedule_id +
        ", team_id=" + team_id +
        ", stack_measurement_id=" + stack_measurement_id +
        ", measure_date=" + measure_date +
        ", is_completed=" + is_completed +
        '}';
  }
}