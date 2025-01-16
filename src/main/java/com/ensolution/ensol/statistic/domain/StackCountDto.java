package com.ensolution.ensol.statistic.domain;

public class StackCountDto {
  private String cycle_type;
  private Integer cnt;
  private Integer workplace_id;

  public StackCountDto() { }

  public StackCountDto(String cycle_type, Integer cnt, Integer workplace_id) {
    this.cycle_type = cycle_type;
    this.cnt = cnt;
    this.workplace_id = workplace_id;
  }

  public String getCycle_type() {
    return cycle_type;
  }

  public void setCycle_type(String cycle_type) {
    this.cycle_type = cycle_type;
  }

  public Integer getCnt() {
    return cnt;
  }

  public void setCnt(Integer cnt) {
    this.cnt = cnt;
  }

  public Integer getWorkplace_id() {
    return workplace_id;
  }

  public void setWorkplace_id(Integer workplace_id) {
    this.workplace_id = workplace_id;
  }

  @Override
  public String toString() {
    return "StackCountDto{" +
        "cycle_type='" + cycle_type + '\'' +
        ", cnt=" + cnt +
        ", workplace_id=" + workplace_id +
        '}';
  }
}