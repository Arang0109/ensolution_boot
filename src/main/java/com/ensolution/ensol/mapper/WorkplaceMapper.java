package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkplaceMapper {
  WorkplaceDto selectOne(Integer workplace_id);
  List<WorkplaceDto> selectWorkplacesOfCompany(Integer id);
  List<WorkplaceDto> selectAll();
  Integer insert(WorkplaceDto workplace);
  Integer update(WorkplaceDto workplace);
  Integer deleteItems(List<Integer> ids);
}
