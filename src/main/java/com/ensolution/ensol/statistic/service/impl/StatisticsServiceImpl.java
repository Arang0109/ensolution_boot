package com.ensolution.ensol.statistic.service.impl;

import com.ensolution.ensol.common.util.StackCountCalculator;
import com.ensolution.ensol.statistic.domain.StackCountDto;
import com.ensolution.ensol.statistic.domain.StatisticsDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;
import com.ensolution.ensol.statistic.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
  private final String[] CYCLE_TYPE = {"monthly", "twiceamonth", "quarterly", "semiannual", "annual"};
  private final StatisticsMapper statisticsMapper;

  @Autowired
  public StatisticsServiceImpl(StatisticsMapper statisticsMapper) {
      this.statisticsMapper = statisticsMapper;
    }
  }

  @Override
  public void getChartStackCount() {

  }
}
