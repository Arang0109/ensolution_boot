package com.ensolution.ensol.dashboard.service.impl;

import com.ensolution.ensol.common.util.StackCountCalculator;
import com.ensolution.ensol.dashboard.mapper.BoardMapper;
import com.ensolution.ensol.dashboard.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StatisticsServiceImplTest {
  @Autowired
  BoardService boardService;
  @Autowired
  BoardMapper boardMapper;

  @Test
  void getChartStackCount() {
    List<Integer> workplace_ids = new ArrayList<>();
    StackCountCalculator sc = new StackCountCalculator(boardMapper, workplace_ids);

    Map<String, Long> result = sc.stackCnt();
    Map<String, Long> expected = sc.completedStackCnt();

    System.out.println(result);
    System.out.println(expected);
  }
}