package com.ensolution.ensol.statistic.mapper;

import com.ensolution.ensol.statistic.domain.StackCountDto;
import com.ensolution.ensol.statistic.domain.StatisticsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
  List<StackCountDto> stackCntAll();
  List<StackCountDto> stackCntNonComplete();
  List<StackCountDto> stackCntAllOfWp(List<Integer> workplace_ids);
  List<StackCountDto> stackCntNonCompleteOfWp(List<Integer> workplace_ids);

  List<StatisticsDto> selectAll(StatisticsDto statisticsDto);
  List<StatisticsDto> selectByWorkplace(StatisticsDto statisticsDto);
}
