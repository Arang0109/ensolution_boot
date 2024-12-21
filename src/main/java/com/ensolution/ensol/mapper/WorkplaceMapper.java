package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.WorkplaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkplaceMapper {
  List<WorkplaceDto> selectWorkplacesOfCompany(Integer id);
}
