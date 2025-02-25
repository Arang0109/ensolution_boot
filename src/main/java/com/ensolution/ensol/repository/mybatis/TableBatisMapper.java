package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.StackMeasurementsOfStackDto;
import com.ensolution.ensol.dto.query.StackTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableBatisMapper {
  List<StackTableDto> selectStacksOfTable();
  List<StackTableDto> selectStacksByWorkplaceOfTable(Integer workplaceId);

  List<StackMeasurementsOfStackDto> stackMeasurementsOfStack(Integer stackId);
}
