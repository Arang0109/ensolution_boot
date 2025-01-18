package com.ensolution.ensol.statistic.service.impl;

import com.ensolution.ensol.common.util.StackCountCalculator;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;
import com.ensolution.ensol.statistic.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
  private final StatisticsMapper statisticsMapper;

  @Autowired
  public StatisticsServiceImpl(StatisticsMapper statisticsMapper) {
      this.statisticsMapper = statisticsMapper;
    }

  @Override
  public Map<String, Map<String, Long>> getChartStackCount() {
    Map<String, Map<String, Long>> result = new HashMap<>();
    List<Integer> workplaceIds = new ArrayList<>();
    workplaceIds.add(1);
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, workplaceIds);

    result.put("allCnt", sc.stackCnt());
    result.put("allCompleteCnt", sc.completedStackCnt());

    return result;
  }

  @Override
  public Map<String, Map<String, Long>> getChartStackCountByWorkplace(List<Integer> workplaceIds) {
    Map<String, Map<String, Long>> result = new HashMap<>();
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, workplaceIds);

    result.put("workplaceCnt", sc.stackCntByWorkplace());
    result.put("workplaceCompleteCnt", sc.completedStackCntByWorkplace());

    return result;
  }
}
