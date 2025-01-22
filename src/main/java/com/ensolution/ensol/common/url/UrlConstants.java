package com.ensolution.ensol.common.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConstants {
  @Value("${management.base}")
  private String MANAGEMENT_BASE;

  @Value("${management.companies}")
  private String MANAGEMENT_COMPANIES;

  @Value("${management.workplaces}")
  private String MANAGEMENT_WORKPLACES;

  @Value("${management.stacks}")
  private String MANAGEMENT_STACKS;

  @Value("${management.measurements}")
  private String MANAGEMENT_MEASUREMENTS;

  @Value("${stacks.information}")
  private String STACKS_INFORMATION;

  public String getMANAGEMENT_BASE() {
    return MANAGEMENT_BASE;
  }

  public String getMANAGEMENT_COMPANIES() {
    return MANAGEMENT_COMPANIES;
  }

  public String getMANAGEMENT_WORKPLACES() {
    return MANAGEMENT_WORKPLACES;
  }

  public String getMANAGEMENT_STACKS() {
    return MANAGEMENT_STACKS;
  }

  public String getMANAGEMENT_MEASUREMENTS() {
    return MANAGEMENT_MEASUREMENTS;
  }

  public String getSTACKS_INFORMATION() {
    return STACKS_INFORMATION;
  }
}
