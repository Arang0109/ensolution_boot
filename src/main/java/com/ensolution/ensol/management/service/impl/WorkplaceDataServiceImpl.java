package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.management.data.dto.WorkplaceDto;
import com.ensolution.ensol.management.data.entity.Workplace;
import com.ensolution.ensol.management.data.mapper.WorkplaceMapper;
import com.ensolution.ensol.management.data.repository.WorkplaceRepository;
import com.ensolution.ensol.management.service.WorkplaceDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkplaceDataServiceImpl implements WorkplaceDataService {
  private final WorkplaceRepository workplaceRepository;
  private final WorkplaceMapper workplaceMapper;

  @Override
  public Optional<WorkplaceDto> findWorkplaceById(Integer id) {
    return workplaceRepository.findById(id).map(workplaceMapper::toDto);
  }

  @Override
  public List<WorkplaceDto> findWorkplacesByCompanyId(Integer companyId) {
    List<Workplace> workplaces = workplaceRepository.findByCompany_CompanyId(companyId);
    return workplaceMapper.toDtoList(workplaces);
  }

  @Override
  public List<WorkplaceDto> findAll() {
    List<Workplace> workplaces = workplaceRepository.findAll();
    return workplaceMapper.toDtoList(workplaces);
  }

  @Override
  public void saveWorkplace(WorkplaceDto workplaceDto) {
    workplaceRepository.save(workplaceMapper.toEntity(workplaceDto));
  }

  @Override
  public void deleteWorkplaces(List<Integer> ids) {
    workplaceRepository.deleteAllById(ids);
  }

  @Override
  public boolean existsById(Integer id) {
    return workplaceRepository.existsById(id);
  }
}
