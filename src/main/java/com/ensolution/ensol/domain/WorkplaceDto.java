package com.ensolution.ensol.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Objects;

@Setter
@Getter
public class WorkplaceDto {
  private Integer workplace_id;
  private Integer company_id;
  private String workplace_name;
  private String address;
  private Date reg_date;

  public WorkplaceDto() {
    this.reg_date = Date.valueOf(LocalDate.now());
  }

  public WorkplaceDto(Integer company_id, String workplace_name, String address) {
    this.company_id = company_id;
    this.workplace_name = workplace_name;
    this.address = address;
    this.reg_date = Date.valueOf(LocalDate.now());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkplaceDto that = (WorkplaceDto) o;
    return Objects.equals(workplace_id, that.workplace_id) && Objects.equals(workplace_name, that.workplace_name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workplace_id, workplace_name);
  }

  @Override
  public String toString() {
    return "WorkplaceDto{" +
        "workplace_id=" + workplace_id +
        ", company_id=" + company_id +
        ", workplace_name='" + workplace_name + '\'' +
        ", address='" + address + '\'' +
        ", reg_date=" + reg_date +
        '}';
  }
}