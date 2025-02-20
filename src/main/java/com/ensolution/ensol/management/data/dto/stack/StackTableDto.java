package com.ensolution.ensol.management.data.dto.stack;

import java.util.Objects;

public class StackTableDto {
  private Integer stack_id;
  private String stack_name;
  private String company_name;
  private String workplace_name;
  private String sub_factory_name;
  private String department_name;

  public StackTableDto() {}

  public StackTableDto(Integer stack_id, String stack_name, String company_name, String workplace_name, String sub_factory_name, String department_name) {
    this.stack_id = stack_id;
    this.stack_name = stack_name;
    this.company_name = company_name;
    this.workplace_name = workplace_name;
    this.sub_factory_name = sub_factory_name;
    this.department_name = department_name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StackTableDto that = (StackTableDto) o;
    return Objects.equals(stack_id, that.stack_id) && Objects.equals(stack_name, that.stack_name) && Objects.equals(company_name, that.company_name) && Objects.equals(workplace_name, that.workplace_name) && Objects.equals(sub_factory_name, that.sub_factory_name) && Objects.equals(department_name, that.department_name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stack_id, stack_name, company_name, workplace_name, sub_factory_name, department_name);
  }

  public Integer getStack_id() {
    return stack_id;
  }

  public void setStack_id(Integer stack_id) {
    this.stack_id = stack_id;
  }

  public String getStack_name() {
    return stack_name;
  }

  public void setStack_name(String stack_name) {
    this.stack_name = stack_name;
  }

  public String getSub_factory_name() {
    return sub_factory_name;
  }

  public void setSub_factory_name(String sub_factory_name) {
    this.sub_factory_name = sub_factory_name;
  }

  public String getDepartment_name() {
    return department_name;
  }

  public void setDepartment_name(String department_name) {
    this.department_name = department_name;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getWorkplace_name() {
    return workplace_name;
  }

  public void setWorkplace_name(String workplace_name) {
    this.workplace_name = workplace_name;
  }

  @Override
  public String toString() {
    return "StackTableDto{" +
        "stack_id=" + stack_id +
        ", stack_name='" + stack_name + '\'' +
        ", company_name='" + company_name + '\'' +
        ", workplace_name='" + workplace_name + '\'' +
        ", sub_factory_name='" + sub_factory_name + '\'' +
        ", department_name='" + department_name + '\'' +
        '}';
  }
}
