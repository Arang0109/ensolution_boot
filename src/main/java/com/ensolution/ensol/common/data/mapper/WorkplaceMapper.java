package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.WorkplaceDto;
import com.ensolution.ensol.common.data.entity.Workplace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkplaceMapper {
  @Mapping(source = "company.companyId", target = "companyId")
  WorkplaceDto toDto(Workplace workplace);
  @Mapping(source = "companyId", target = "company.companyId")
  Workplace toEntity(WorkplaceDto workplaceDto);
  List<WorkplaceDto> toDtoList(List<Workplace> workplaces);
}
