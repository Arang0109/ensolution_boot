package com.ensolution.ensol.statistic.service.impl;

import com.ensolution.ensol.statistic.domain.StackCountDto;
import com.ensolution.ensol.statistic.mapper.StatisticsMapper;
import com.ensolution.ensol.statistic.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
  private final StatisticsMapper statisticsMapper;

  public StatisticsServiceImpl(StatisticsMapper statisticsMapper) {
    this.statisticsMapper = statisticsMapper;
  }

  @Override
  public Map<String,Integer> getCompleteStackCnt() {
    List<StackCountDto> a = statisticsMapper.stackCntAll();
    List<StackCountDto> b = statisticsMapper.stackCntNonComplete();
    Map<String, Integer> result = new HashMap<>();

    for (int i = 0; i < a.size(); i++) {
      String cycle_type = a.get(i).getCycle_type();
      Integer cnt = a.get(i).getCnt() - b.get(i).getCnt();
      result.put(cycle_type,cnt);
    }

    return result;
  }

  @Override
  public Map<String,Integer> getNonCompleteStackCnt() {
    List<StackCountDto> a = statisticsMapper.stackCntNonComplete();
    Map<String, Integer> result = new HashMap<>();

    for (int i = 0; i < a.size(); i++) {
      String cycle_type = a.get(i).getCycle_type();
      Integer cnt = a.get(i).getCnt();
      result.put(cycle_type,cnt);
    }

    return result;
  }

  @Override
  public Map<String,Integer> getCompleteStackCntOfWorkplace(List<Integer> workplace_ids) {
    List<StackCountDto> a = statisticsMapper.stackCntAllOfWp(workplace_ids);
    List<StackCountDto> b = statisticsMapper.stackCntNonCompleteOfWp(workplace_ids);
    Map<String, Integer> result = new HashMap<>();

    for (int i = 0; i < a.size(); i++) {
      String cycle_type = a.get(i).getCycle_type();
      Integer cnt = a.get(i).getCnt() - b.get(i).getCnt();
      result.put(cycle_type,cnt);
    }

    return result;
  }

  @Override
  public Map<String,Integer> getNonCompleteStackCntOfWorkplace(List<Integer> workplace_ids) {
    List<StackCountDto> a = statisticsMapper.stackCntNonCompleteOfWp(workplace_ids);
    Map<String, Integer> result = new HashMap<>();

    for (int i = 0; i < a.size(); i++) {
      String cycle_type = a.get(i).getCycle_type();
      Integer cnt = a.get(i).getCnt();
      result.put(cycle_type,cnt);
    }

    return result;
  }
}
