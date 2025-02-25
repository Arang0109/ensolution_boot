package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.table.StackMeasurementTableDto;
import com.ensolution.ensol.dto.query.table.StackTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableInformationMapper {
  List<StackTableDto> selectStacksOfTable();
  List<StackTableDto> selectStacksByWorkplaceOfTable(Integer workplaceId);

  List<StackMeasurementTableDto> stackMeasurementsOfStack(Integer stackId);
}
