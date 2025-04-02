package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.HistoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
  List<HistoryDto> selectStackHistory(Integer stackId);
}
