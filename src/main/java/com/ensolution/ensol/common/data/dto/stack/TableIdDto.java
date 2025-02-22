package com.ensolution.ensol.common.data.dto.stack;

public class TableIdDto {
  private Integer companyId;
  private Integer workplaceId;
  private Integer stackId;

  public TableIdDto() {}

  public TableIdDto(Integer companyId, Integer workplaceId, Integer stackId) {
    this.companyId = companyId;
    this.workplaceId = workplaceId;
    this.stackId = stackId;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public Integer getWorkplaceId() {
    return workplaceId;
  }

  public void setWorkplaceId(Integer workplaceId) {
    this.workplaceId = workplaceId;
  }

  public Integer getStackId() {
    return stackId;
  }

  public void setStackId(Integer stackId) {
    this.stackId = stackId;
  }

  @Override
  public String toString() {
    return "TableIdDto{" +
        "companyId=" + companyId +
        ", workplaceId=" + workplaceId +
        ", stackId=" + stackId +
        '}';
  }
}
