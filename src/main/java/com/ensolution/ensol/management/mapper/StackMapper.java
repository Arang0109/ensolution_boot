package com.ensolution.ensol.management.mapper;

import com.ensolution.ensol.management.domain.stack.StackDto;
import com.ensolution.ensol.management.domain.stack.StackInformationDto;
import com.ensolution.ensol.management.domain.stack.StackTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StackMapper {
  StackDto selectStack(Integer stack_id);
  List<StackDto> selectAll();
  List<StackTableDto> selectStacksOfWorkplace(Integer workplace_id);
  List<StackTableDto> selectAllOfTable();
  Integer insert(StackDto stack);
  Integer update(StackDto stack);
  Integer updateStackInfo(StackInformationDto stackInformation);
  Integer deleteItems(List<Integer> ids);
}
