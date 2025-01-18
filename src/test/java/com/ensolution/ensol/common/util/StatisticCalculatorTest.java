package com.ensolution.ensol.common.util;

import com.ensolution.ensol.statistic.domain.StatisticsDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticCalculatorTest {
  @Autowired
  StatisticsMapper statisticsMapper;

  @Test
  void stackCnt() {
    StatisticsDto statisticsDto = new StatisticsDto();
    statisticsDto.setCycle_type("monthly");
    statisticsDto.setWorkplace_id(30);
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, statisticsDto);
    System.out.println("전체 스택 수 : " + sc.stackCnt());
  }

  @Test
  void stackCntByWorkplace() {
    StatisticsDto statisticsDto = new StatisticsDto();
    statisticsDto.setCycle_type("monthly");
    statisticsDto.setWorkplace_id(30);
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, statisticsDto);
    System.out.println("사업장 스택 수 : " + sc.stackCntByWorkplace());
  }

  @Test
  void completedStackCnt() {
    StatisticsDto statisticsDto = new StatisticsDto();
    statisticsDto.setCycle_type("monthly");
    statisticsDto.setWorkplace_id(30);
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, statisticsDto);
    System.out.println("전체 완료 스택 수 : " + sc.completedStackCnt());
  }

  @Test
  void completedStackCntByWorkplace() {
    StatisticsDto statisticsDto = new StatisticsDto();
    statisticsDto.setCycle_type("monthly");
    statisticsDto.setWorkplace_id(30);
    StackCountCalculator sc = new StackCountCalculator(statisticsMapper, statisticsDto);
    System.out.println("사업장 완료 스택 수 : " + sc.completedStackCntByWorkplace());
  }
}