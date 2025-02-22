package com.ensolution.ensol.management.service;

import com.ensolution.ensol.common.data.dto.StackDto;
import com.ensolution.ensol.common.data.dto.StackImageDto;
import com.ensolution.ensol.common.data.dto.StackInformationDto;

import java.util.List;

public interface StackDataService {
  boolean existsStackById(Integer stackId);

  void saveStack(StackDto stackDto);

  void saveStackInformation(StackInformationDto stackInformationDto);

  // 시설 사진 업로드 서비스
  void saveStackImage(StackImageDto stackImageDto);

  // 특정 시설 사진 조회
  List<StackImageDto> findAllStackImages(Integer stackId);

  // 특정 시설 조회
  StackDto findStackById(Integer stackId);

  // 시설 목록 조회
  List<StackDto> findAllStacks();

  // 특정 사업장의 시설 목록 조회
  List<StackDto> findAllStacksByWorkplaceId(Integer workplaceId);

  void deleteStacks(List<Integer> ids);
}
