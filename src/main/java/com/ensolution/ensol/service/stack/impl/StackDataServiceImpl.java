package com.ensolution.ensol.service.stack.impl;

import com.ensolution.ensol.dto.entity.stack.StackDto;
import com.ensolution.ensol.dto.entity.stack.StackImageDto;
import com.ensolution.ensol.dto.entity.stack.StackInformationDto;
import com.ensolution.ensol.dto.query.HistoryDto;
import com.ensolution.ensol.entity.company.Factory;
import com.ensolution.ensol.entity.stack.Stack;
import com.ensolution.ensol.mapper.stack.StackImageMapper;
import com.ensolution.ensol.mapper.stack.StackInformationMapper;
import com.ensolution.ensol.mapper.stack.StackMapper;
import com.ensolution.ensol.repository.jpa.company.FactoryRepository;
import com.ensolution.ensol.repository.jpa.stack.StackImageRepository;
import com.ensolution.ensol.repository.jpa.stack.StackInformationRepository;
import com.ensolution.ensol.repository.jpa.stack.StackRepository;
import com.ensolution.ensol.repository.mybatis.HistoryMapper;
import com.ensolution.ensol.service.stack.StackDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StackDataServiceImpl implements StackDataService {
  private final StackRepository stackRepository;
  private final StackInformationRepository stackInformationRepository;
  private final StackImageRepository stackImageRepository;
  private final StackMapper stackMapper;
  private final StackInformationMapper stackInformationMapper;
  private final StackImageMapper stackImageMapper;
  private final FactoryRepository factoryRepository;
  private final HistoryMapper historyMapper;

  @Override
  public boolean existsStackById(Integer stackId) {
    return stackRepository.existsById(stackId);
  }

  @Override
  @Transactional
  public void saveStack(StackDto stackDto) {
    Stack stack = stackMapper.toEntity(stackDto);

    if (stackDto.getFactoryId() != null) {
      Factory factory = factoryRepository.findById(stackDto.getFactoryId())
          .orElseThrow(() -> new RuntimeException("Factory not found"));
      stack.setFactory(factory);
    } else {
      stack.setFactory(null);
    }

    stackRepository.save(stack);
  }

  @Override
  @Transactional
  public void updateStack(StackDto stackDto) {
    Stack stack = stackRepository.findById(stackDto.getStackId())
        .orElseThrow(() -> new RuntimeException("stack not found"));

    if (stackDto.getStackName() != null) {
      stack.setStackName(stackDto.getStackName());
    }

    if (stackDto.getPrevention() != null) {
      stack.setPrevention(stackDto.getPrevention());
    }

    if (stackDto.getNote() != null) {
      stack.setNote(stackDto.getNote());
    }
  }

  @Override
  public void saveStackInformation(StackInformationDto stackInformationDto) {
    stackInformationRepository.save(stackInformationMapper.toEntity(stackInformationDto));
  }

  // 시설 사진 업로드 서비스
  @Override
  public void saveStackImage(StackImageDto stackImageDto) {
    stackImageRepository.save(stackImageMapper.toEntity(stackImageDto));
  }

  // 특정 시설 사진 조회
  @Override
  public List<StackImageDto> findAllStackImages(Integer stackId) {
    Stack stack = stackRepository.findWithStackImagesByStackId(stackId)
        .orElseThrow(() -> new RuntimeException("Stack not found"));

    return stackImageMapper.toDtoList(stack.getStackImages());
  }

  // 특정 시설 조회
  @Override
  public StackDto findStackById(Integer stackId) {
    Stack stack = stackRepository.findById(stackId)
        .orElseThrow(() -> new RuntimeException("stack not found"));

    return stackMapper.toDto(stack);
  }

  // 시설 목록 조회
  @Override
  public List<StackDto> findAllStacks() {
    List<Stack> stacks = stackRepository.findAll();
    return stackMapper.toDtoList(stacks);
  }

  // 특정 사업장의 시설 목록 조회
  @Override
  public List<StackDto> findAllStacksByWorkplaceId(Integer workplaceId) {
    List<Stack> stacks = stackRepository.findByWorkplace_WorkplaceId(workplaceId);
    return stackMapper.toDtoList(stacks);
  }

  @Override
  public void deleteStacks(List<Integer> ids) {
    stackRepository.deleteAllById(ids);
  }

  @Override
  public List<HistoryDto> selectStackHistory(Integer stackId) {
    return historyMapper.selectStackHistory(stackId);
  }
}
