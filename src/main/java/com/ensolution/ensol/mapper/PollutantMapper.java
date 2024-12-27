package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.management.stack.PollutantDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PollutantMapper {
  PollutantDto selectPollutant(Integer stack_id);
  List<PollutantDto> selectAll();
}
