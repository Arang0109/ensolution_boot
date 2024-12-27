package com.ensolution.ensol.domain.management.company;

public class DepartmentDto {
  private Integer management_department_id;
  private Integer workplace_id;
  private String name;
  private String tel;

  public DepartmentDto() {}

  public DepartmentDto(Integer management_department_id, Integer workplace_id, String name, String tel) {
    this.management_department_id = management_department_id;
    this.workplace_id = workplace_id;
    this.name = name;
    this.tel = tel;
  }

  public Integer getManagement_department_id() {
    return management_department_id;
  }

  public void setManagement_department_id(Integer management_department_id) {
    this.management_department_id = management_department_id;
  }

  public Integer getWorkplace_id() {
    return workplace_id;
  }

  public void setWorkplace_id(Integer workplace_id) {
    this.workplace_id = workplace_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  @Override
  public String toString() {
    return "DepartmentDto{" +
        "management_department_id=" + management_department_id +
        ", workplace_id=" + workplace_id +
        ", name='" + name + '\'' +
        ", tel='" + tel + '\'' +
        '}';
  }
}
