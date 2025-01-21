package com.ensolution.ensol.management.mapper;

import com.ensolution.ensol.management.domain.stack.PollutantDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PollutantMapper {
  PollutantDto selectPollutant(Integer stack_id);
  List<PollutantDto> selectAll();

  Integer selectPollutantIdByName(String pollutant_name);
}
