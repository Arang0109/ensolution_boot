package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.common.data.dto.StackDto;
import com.ensolution.ensol.common.data.dto.StackImageDto;
import com.ensolution.ensol.common.data.dto.StackInformationDto;
import com.ensolution.ensol.common.data.entity.Stack;
import com.ensolution.ensol.common.data.entity.StackImage;
import com.ensolution.ensol.common.data.mapper.StackImageMapper;
import com.ensolution.ensol.common.data.mapper.StackInformationMapper;
import com.ensolution.ensol.common.data.mapper.StackMapper;
import com.ensolution.ensol.common.data.repository.StackImageRepository;
import com.ensolution.ensol.common.data.repository.StackInformationRepository;
import com.ensolution.ensol.common.data.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StackDataService {
  private final StackRepository stackRepository;
  private final StackInformationRepository stackInformationRepository;
  private final StackImageRepository stackImageRepository;
  private final StackMapper stackMapper;
  private final StackInformationMapper stackInformationMapper;
  private final StackImageMapper stackImageMapper;

  public boolean existsStackById(Integer stackId) {
    return stackRepository.existsById(stackId);
  }

  public void saveStack(StackDto stackDto) {
    stackRepository.save(stackMapper.toEntity(stackDto));
  }

  public void saveStackInformation(StackInformationDto stackInformationDto) {
    stackInformationRepository.save(stackInformationMapper.toEntity(stackInformationDto));
  }

  // 시설 사진 업로드 서비스
  public void saveStackImage(StackImageDto stackImageDto) {
    stackImageRepository.save(stackImageMapper.toEntity(stackImageDto));
  }

  // 특정 시설 사진 조회
  public List<StackImageDto> findAllStackImages(Integer stackId) {
    Stack stack = stackRepository.findWithStackImagesByStackId(stackId)
        .orElseThrow(() -> new RuntimeException("Stack not found"));

    return stackImageMapper.toDtoList(stack.getStackImages());
  }

  // 특정 시설 조회
  public StackDto findStackById(Integer stackId) {
    Stack stack = stackRepository.findById(stackId)
        .orElseThrow(() -> new RuntimeException("stack not found"));

    return stackMapper.toDto(stack);
  }

  // 시설 목록 조회
  public List<StackDto> findAllStacks() {
    List<Stack> stacks = stackRepository.findAll();
    return stackMapper.toDtoList(stacks);
  }

  // 특정 사업장의 시설 목록 조회
  public List<StackDto> findAllStacksByWorkplaceId(Integer workplaceId) {
    List<Stack> stacks = stackRepository.findByWorkplace_WorkplaceId(workplaceId);
    return stackMapper.toDtoList(stacks);
  }

  public void deleteStacks(List<Integer> ids) {
    stackRepository.deleteAllById(ids);
  }
}
