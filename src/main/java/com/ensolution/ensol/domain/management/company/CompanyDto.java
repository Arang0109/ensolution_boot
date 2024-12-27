package com.ensolution.ensol.domain.management.company;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class CompanyDto {
  private Integer company_id;
  private String company_name;
  private String address;
  private String ceo_name;
  private String biz_number;
  private final Date reg_date;

  public CompanyDto() {
    this.reg_date = Date.valueOf(LocalDate.now());
  }

  public CompanyDto(Integer company_id, String company_name, String address, String ceo_name, String biz_number) {
    this.company_id = company_id;
    this.company_name = company_name;
    this.address = address;
    this.ceo_name = ceo_name;
    this.biz_number = biz_number;
    this.reg_date = Date.valueOf(LocalDate.now());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CompanyDto that = (CompanyDto) o;
    return Objects.equals(company_id, that.company_id) && Objects.equals(company_name, that.company_name) && Objects.equals(address, that.address) && Objects.equals(ceo_name, that.ceo_name) && Objects.equals(biz_number, that.biz_number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company_id, company_name, address, ceo_name, biz_number);
  }

  public Integer getCompany_id() {
    return company_id;
  }

  public void setCompany_id(Integer company_id) {
    this.company_id = company_id;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCeo_name() {
    return ceo_name;
  }

  public void setCeo_name(String ceo_name) {
    this.ceo_name = ceo_name;
  }

  public String getBiz_number() {
    return biz_number;
  }

  public void setBiz_number(String biz_number) {
    this.biz_number = biz_number;
  }

  public Date getReg_date() {
    return reg_date;
  }

  @Override
  public String toString() {
    return "CompanyDto{" +
            "company_id=" + company_id +
            ", company_name='" + company_name + '\'' +
            ", address='" + address + '\'' +
            ", ceo_name='" + ceo_name + '\'' +
            ", biz_number='" + biz_number + '\'' +
            ", reg_date=" + reg_date +
            '}';
  }
}