package com.ensolution.ensol.management.data.dto.stack;

import java.util.Objects;

public class StackInformationDto {
  private Integer stack_info_id;
  private Double diameter;
  private Double dynamic_pressure;
  private Double static_pressure;
  private Double velocity_speed;
  private Double quantity;
  private Double temperature;

  public StackInformationDto() {}

  public StackInformationDto(Integer stack_info_id, Double diameter, Double dynamic_pressure, Double static_pressure, Double velocity_speed, Double quantity, Double temperature) {
    this.stack_info_id = stack_info_id;
    this.diameter = diameter;
    this.dynamic_pressure = dynamic_pressure;
    this.static_pressure = static_pressure;
    this.velocity_speed = velocity_speed;
    this.quantity = quantity;
    this.temperature = temperature;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StackInformationDto that = (StackInformationDto) o;
    return Objects.equals(stack_info_id, that.stack_info_id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(stack_info_id);
  }

  public Integer getStack_info_id() {
    return stack_info_id;
  }

  public void setStack_info_id(Integer stack_info_id) {
    this.stack_info_id = stack_info_id;
  }

  public Double getDiameter() {
    return diameter;
  }

  public void setDiameter(Double diameter) {
    this.diameter = diameter;
  }

  public Double getDynamic_pressure() {
    return dynamic_pressure;
  }

  public void setDynamic_pressure(Double dynamic_pressure) {
    this.dynamic_pressure = dynamic_pressure;
  }

  public Double getStatic_pressure() {
    return static_pressure;
  }

  public void setStatic_pressure(Double static_pressure) {
    this.static_pressure = static_pressure;
  }

  public Double getVelocity_speed() {
    return velocity_speed;
  }

  public void setVelocity_speed(Double velocity_speed) {
    this.velocity_speed = velocity_speed;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  @Override
  public String toString() {
    return "StackInfoDto{" +
        "stack_info_id=" + stack_info_id +
        ", diameter=" + diameter +
        ", dynamic_pressure=" + dynamic_pressure +
        ", static_pressure=" + static_pressure +
        ", velocity_speed=" + velocity_speed +
        ", quantity=" + quantity +
        ", temperature=" + temperature +
        '}';
  }
}
