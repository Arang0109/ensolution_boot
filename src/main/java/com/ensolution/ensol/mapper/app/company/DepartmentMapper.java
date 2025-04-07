package com.ensolution.ensol.mapper.app.company;

import com.ensolution.ensol.dto.app.entity.company.DepartmentDto;
import com.ensolution.ensol.entity.app.company.Department;
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
