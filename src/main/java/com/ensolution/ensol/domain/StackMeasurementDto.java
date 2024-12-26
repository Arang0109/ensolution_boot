package com.ensolution.ensol.domain;

import java.util.Objects;

public class StackMeasurementDto {
  private Integer stack_measurement_id;
  private Integer stack_id;
  private Integer pollutant_id;
  private String cycle_type;
  private Boolean is_completed;
  private String pollutant_name;
  private String pollutant_name_en;
  private String method;
  private Boolean is_measure;
  private Double allow_value;

  public StackMeasurementDto() {}

  public StackMeasurementDto(Integer stack_measurement_id, Integer stack_id, Integer pollutant_id, String cycle_type, Boolean is_completed, String pollutant_name, String pollutant_name_en, String method, Boolean is_measure, Double allow_value) {
    this.stack_measurement_id = stack_measurement_id;
    this.stack_id = stack_id;
    this.pollutant_id = pollutant_id;
    this.cycle_type = cycle_type;
    this.is_completed = is_completed;
    this.pollutant_name = pollutant_name;
    this.pollutant_name_en = pollutant_name_en;
    this.method = method;
    this.is_measure = is_measure;
    this.allow_value = allow_value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StackMeasurementDto that = (StackMeasurementDto) o;
    return Objects.equals(stack_measurement_id, that.stack_measurement_id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(stack_measurement_id);
  }

  public Integer getStack_measurement_id() {
    return stack_measurement_id;
  }

  public void setStack_measurement_id(Integer stack_measurement_id) {
    this.stack_measurement_id = stack_measurement_id;
  }

  public String getPollutant_name() {
    return pollutant_name;
  }

  public void setPollutant_name(String pollutant_name) {
    this.pollutant_name = pollutant_name;
  }

  public String getPollutant_name_en() {
    return pollutant_name_en;
  }

  public void setPollutant_name_en(String pollutant_name_en) {
    this.pollutant_name_en = pollutant_name_en;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Integer getStack_id() {
    return stack_id;
  }

  public void setStack_id(Integer stack_id) {
    this.stack_id = stack_id;
  }

  public Integer getPollutant_id() {
    return pollutant_id;
  }

  public void setPollutant_id(Integer pollutant_id) {
    this.pollutant_id = pollutant_id;
  }

  public String getCycle_type() {
    return cycle_type;
  }

  public void setCycle_type(String cycle_type) {
    this.cycle_type = cycle_type;
  }

  public Boolean getIs_completed() {
    return is_completed;
  }

  public void setIs_completed(Boolean is_completed) {
    this.is_completed = is_completed;
  }

  public Boolean getIs_measure() {
    return is_measure;
  }

  public void setIs_measure(Boolean is_measure) {
    this.is_measure = is_measure;
  }

  public Double getAllow_value() {
    return allow_value;
  }

  public void setAllow_value(Double allow_value) {
    this.allow_value = allow_value;
  }

  @Override
  public String toString() {
    return "StackMeasurementDto{" +
        "stack_measurement_id=" + stack_measurement_id +
        ", stack_id=" + stack_id +
        ", pollutant_id=" + pollutant_id +
        ", cycle_type='" + cycle_type + '\'' +
        ", is_completed=" + is_completed +
        ", pollutant_name='" + pollutant_name + '\'' +
        ", pollutant_name_en='" + pollutant_name_en + '\'' +
        ", method='" + method + '\'' +
        ", is_measure=" + is_measure +
        ", allow_value=" + allow_value +
        '}';
  }
}
