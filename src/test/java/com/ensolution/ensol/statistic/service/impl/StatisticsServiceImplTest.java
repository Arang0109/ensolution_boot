package com.ensolution.ensol.statistic.service.impl;

import com.ensolution.ensol.common.util.StackCountCalculator;
import com.ensolution.ensol.statistic.domain.StatisticsDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;
import com.ensolution.ensol.statistic.service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticsServiceImplTest {
  @Autowired
  StatisticsService statisticsService;
  @Autowired
  StatisticsMapper statisticsMapper;

  @Test
  void getChartStackCount() {
    List<Integer> workplace_ids = new ArrayList<>();
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, workplace_ids);

    Map<String, Long> result = sc.stackCnt();
    Map<String, Long> expected = sc.completedStackCnt();

    System.out.println(result);
    System.out.println(expected);
  }
}