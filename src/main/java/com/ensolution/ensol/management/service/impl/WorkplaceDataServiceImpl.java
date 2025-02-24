package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.WorkplaceDto;
import com.ensolution.ensol.common.data.entity.Company;
import com.ensolution.ensol.common.data.entity.Workplace;
import com.ensolution.ensol.common.data.mapper.WorkplaceMapper;
import com.ensolution.ensol.common.data.repository.CompanyRepository;
import com.ensolution.ensol.common.data.repository.WorkplaceRepository;
import com.ensolution.ensol.management.service.WorkplaceDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkplaceDataServiceImpl implements WorkplaceDataService {
  private final CompanyRepository companyRepository;
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
  public Integer findFactoryId(Integer workplaceId) {


    return 0;
  }

  @Override
  @Transactional
  public void saveWorkplace(WorkplaceDto workplaceDto) {
    Workplace workplace = workplaceMapper.toEntity(workplaceDto);
    workplaceRepository.save(workplace);
  }

  @Override
  @Transactional
  public void updateWorkplace(WorkplaceDto workplaceDto) {
    Workplace workplace = workplaceRepository.findById(workplaceDto.getWorkplaceId())
        .orElseThrow(() -> new RuntimeException("Workplace not found"));

    if (workplaceDto.getWorkplaceName() != null) {
      workplace.setWorkplaceName(workplaceDto.getWorkplaceName());
    }

    if (workplaceDto.getAddress() != null) {
      workplace.setAddress(workplaceDto.getAddress());
    }
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
