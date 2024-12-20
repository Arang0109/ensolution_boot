package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StackMapper {
  StackDto selectStack(Integer id);
}
