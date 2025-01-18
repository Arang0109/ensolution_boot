package com.ensolution.ensol.statistic.service;


import java.util.List;
import java.util.Map;

public interface StatisticsService {
  Map<String, Map<String, Long>> getChartStackCount();
  Map<String, Map<String, Long>> getChartStackCountByWorkplace(List<Integer> workplaceIds);
}
