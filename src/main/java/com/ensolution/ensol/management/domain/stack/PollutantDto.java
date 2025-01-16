package com.ensolution.ensol.management.domain.stack;

import java.util.Objects;

public class PollutantDto {
  private Integer pollutant_id;
  private String pollutant_name;
  private String pollutant_name_en;
  private String method;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PollutantDto that = (PollutantDto) o;
    return Objects.equals(pollutant_id, that.pollutant_id) && Objects.equals(pollutant_name, that.pollutant_name) && Objects.equals(pollutant_name_en, that.pollutant_name_en) && Objects.equals(method, that.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pollutant_id, pollutant_name, pollutant_name_en, method);
  }

  public Integer getPollutant_id() {
    return pollutant_id;
  }

  public void setPollutant_id(Integer pollutant_id) {
    this.pollutant_id = pollutant_id;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPollutant_name_en() {
    return pollutant_name_en;
  }

  public void setPollutant_name_en(String pollutant_name_en) {
    this.pollutant_name_en = pollutant_name_en;
  }

  public String getPollutant_name() {
    return pollutant_name;
  }

  public void setPollutant_name(String pollutant_name) {
    this.pollutant_name = pollutant_name;
  }

  @Override
  public String toString() {
    return "PollutantDto{" +
        "pollutant_id=" + pollutant_id +
        ", pollutant_name='" + pollutant_name + '\'' +
        ", pollutant_name_en='" + pollutant_name_en + '\'' +
        ", method='" + method + '\'' +
        '}';
  }
}