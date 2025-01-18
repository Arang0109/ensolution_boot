package com.ensolution.ensol.common.util;

import com.ensolution.ensol.statistic.domain.StatisticsDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackCountCalculator {
  private final String[] CYCLE_TYPE = {"monthly", "twiceamonth", "quarterly", "semiannual", "annual"};
  private final List<StatisticsDto> stacks;
  private final List<StatisticsDto> stacksByWorkplace;

  public StackCountCalculator(StatisticsMapper statisticsMapper, List<Integer> workplaceIds) {
    this.stacks = statisticsMapper.selectAll();
    this.stacksByWorkplace = statisticsMapper.selectByWorkplace(workplaceIds);
  }

  private Map<String, Long> nonComplete(List<StatisticsDto> stack) {
    Map<String, Long> stackCnt = new HashMap<>();
    for (String cycle : CYCLE_TYPE) {
      stackCnt.put(
          cycle, // 주기
          stack // 시설 수
              .stream()
              .filter(s -> !s.is_completed())
              .filter(s -> s.getCycle_type().equals(cycle))
              .count());
    }
    return stackCnt;
  }

  private Map<String, Long> complete(List<StatisticsDto> stack) {
    Map<String, Long> stackCnt = new HashMap<>();
    for (String cycle : CYCLE_TYPE) {
      stackCnt.put(
          cycle, // 주기
          stack // 시설 수
              .stream()
              .filter(StatisticsDto::is_completed)
              .filter(s -> s.getCycle_type().equals(cycle))
              .count());
    }
    return stackCnt;
  }

  public Map<String, Long> stackCnt() {
    return nonComplete(stacks);
  }

  public Map<String, Long> stackCntByWorkplace() {
    return nonComplete(stacksByWorkplace);
  }

  public Map<String, Long> completedStackCnt() {
    return complete(stacks);
  }

  public Map<String, Long> completedStackCntByWorkplace() {
    return complete(stacksByWorkplace);
  }
}
