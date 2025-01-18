package com.ensolution.ensol.statistic.mapper;

import com.ensolution.ensol.statistic.domain.StackCountDto;
import com.ensolution.ensol.statistic.domain.StatisticsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
  List<StatisticsDto> selectAll();
  List<StatisticsDto> selectByWorkplace(List<Integer> workplace_ids);
}
