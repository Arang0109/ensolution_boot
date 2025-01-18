package com.ensolution.ensol.common.util;

import com.ensolution.ensol.statistic.domain.StatisticsDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;

import java.util.List;

public class StackCountCalculator {
  private final List<StatisticsDto> stacks;
  private final List<StatisticsDto> stacksByWorkplace;

  public StackCountCalculator(StatisticsMapper statisticsMapper, StatisticsDto statisticsDto) {
    this.stacks = statisticsMapper.selectAll(statisticsDto);
    this.stacksByWorkplace = statisticsMapper.selectByWorkplace(statisticsDto);
  }

  public long stackCnt() {
    return stacks.size();
  }

  public long stackCntByWorkplace() {
    return stacksByWorkplace.size();
  }

  public long completedStackCnt() {
    return completedCnt(stacks);
  }

  public long completedStackCntByWorkplace() {
    return completedCnt(stacksByWorkplace);
  }

  private long completedCnt(List<StatisticsDto> lists) {
    return lists.stream()
        .filter(StatisticsDto::is_completed)
        .count();
  }
}
