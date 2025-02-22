package com.ensolution.ensol.common.data.dto.stack;

import java.util.Objects;

public class StackTableDto {
  private Integer stackId;
  private String stackName;
  private String companyName;
  private String workplaceName;
  private String factoryCategory;
  private String factoryName;
  private String departmentName;

  public StackTableDto() {}

  public StackTableDto(Integer stackId, String stackName, String companyName, String workplaceName, String factoryCategory, String factoryName, String departmentName) {
    this.stackId = stackId;
    this.stackName = stackName;
    this.companyName = companyName;
    this.workplaceName = workplaceName;
    this.factoryCategory = factoryCategory;
    this.factoryName = factoryName;
    this.departmentName = departmentName;
  }

  public Integer getStackId() {
    return stackId;
  }

  public void setStackId(Integer stackId) {
    this.stackId = stackId;
  }

  public String getStackName() {
    return stackName;
  }

  public void setStackName(String stackName) {
    this.stackName = stackName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getWorkplaceName() {
    return workplaceName;
  }

  public void setWorkplaceName(String workplaceName) {
    this.workplaceName = workplaceName;
  }

  public String getFactoryCategory() {
    return factoryCategory;
  }

  public void setFactoryCategory(String factoryCategory) {
    this.factoryCategory = factoryCategory;
  }

  public String getFactoryName() {
    return factoryName;
  }

  public void setFactoryName(String factoryName) {
    this.factoryName = factoryName;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  @Override
  public String toString() {
    return "StackTableDto{" +
        "stackId=" + stackId +
        ", stackName='" + stackName + '\'' +
        ", companyName='" + companyName + '\'' +
        ", workplaceName='" + workplaceName + '\'' +
        ", factoryCategory='" + factoryCategory + '\'' +
        ", factoryName='" + factoryName + '\'' +
        ", departmentName='" + departmentName + '\'' +
        '}';
  }
}
