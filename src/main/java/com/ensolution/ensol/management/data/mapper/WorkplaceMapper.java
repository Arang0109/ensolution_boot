package com.ensolution.ensol.management.data.mapper;

import com.ensolution.ensol.management.data.dto.company.DepartmentDto;
import com.ensolution.ensol.management.data.dto.company.SubFactoryDto;
import com.ensolution.ensol.management.data.dto.company.WorkplaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkplaceMapper {
  WorkplaceDto selectWorkplace(Integer workplace_id);
  List<SubFactoryDto> selectFactory(Integer workplace_id);
  List<DepartmentDto> selectDepartment(Integer workplace_id);
  List<WorkplaceDto> selectWorkplacesOfCompany(Integer id);
  List<WorkplaceDto> selectAll();
  Integer insert(WorkplaceDto workplace);
  Integer update(WorkplaceDto workplace);
  Integer deleteItems(List<Integer> ids);
}
