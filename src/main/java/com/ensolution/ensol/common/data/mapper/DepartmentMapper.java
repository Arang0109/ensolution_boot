package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.DepartmentDto;
import com.ensolution.ensol.common.data.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
  @Mapping(source = "workplace.workplaceId", target = "workplaceId")
  DepartmentDto toDto(Department department);
  @Mapping(source = "workplaceId", target = "workplace.workplaceId")
  Department toEntity(DepartmentDto departmentDto);
  List<DepartmentDto> toDtoList(List<Department> departments);
}
