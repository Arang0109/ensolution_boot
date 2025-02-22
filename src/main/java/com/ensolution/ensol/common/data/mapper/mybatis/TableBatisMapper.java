package com.ensolution.ensol.common.data.mapper.mybatis;

import com.ensolution.ensol.common.data.dto.stack.StackTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableBatisMapper {
  List<StackTableDto> selectStacksOfTable();
  List<StackTableDto> selectStacksByWorkplaceOfTable(Integer workplaceId);
}
