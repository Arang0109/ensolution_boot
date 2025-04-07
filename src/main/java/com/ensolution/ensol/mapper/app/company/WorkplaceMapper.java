package com.ensolution.ensol.mapper.app.company;

import com.ensolution.ensol.dto.app.entity.company.WorkplaceDto;
import com.ensolution.ensol.entity.app.company.Workplace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface WorkplaceMapper {
  @Mapping(source = "company.companyId", target = "companyId")
  WorkplaceDto toDto(Workplace workplace);
  @Mapping(source = "companyId", target = "company.companyId")
  Workplace toEntity(WorkplaceDto workplaceDto);
  List<WorkplaceDto> toDtoList(List<Workplace> workplaces);
}
