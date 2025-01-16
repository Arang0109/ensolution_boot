package com.ensolution.ensol.statistic.domain;

import java.util.Map;

public class ChartDataResponse {
  private Map<String, Integer> completeStats;
  private Map<String, Integer> nonCompleteStats;

  public ChartDataResponse() {}

  public ChartDataResponse(Map<String, Integer> completeStats, Map<String, Integer> nonCompleteStats) {
    this.completeStats = completeStats;
    this.nonCompleteStats = nonCompleteStats;
  }

  public Map<String, Integer> getCompleteStats() {
    return completeStats;
  }

  public void setCompleteStats(Map<String, Integer> completeStats) {
    this.completeStats = completeStats;
  }

  public Map<String, Integer> getNonCompleteStats() {
    return nonCompleteStats;
  }

  public void setNonCompleteStats(Map<String, Integer> nonCompleteStats) {
    this.nonCompleteStats = nonCompleteStats;
  }

  @Override
  public String toString() {
    return "ChartDataResponse{" +
        "completeStats=" + completeStats +
        ", nonCompleteStats=" + nonCompleteStats +
        '}';
  }
}
