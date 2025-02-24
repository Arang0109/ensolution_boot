package com.ensolution.ensol.common.service;

import com.ensolution.ensol.common.data.dto.StackMeasurementDto;
import com.ensolution.ensol.common.data.dto.stack.ExcelStackMeasurementDto;
import com.ensolution.ensol.common.data.entity.Pollutant;
import com.ensolution.ensol.common.data.entity.Stack;
import com.ensolution.ensol.common.data.mapper.PollutantMapper;
import com.ensolution.ensol.common.data.mapper.StackMapper;
import com.ensolution.ensol.common.data.mapper.StackMeasurementMapper;
import com.ensolution.ensol.common.data.repository.PollutantRepository;
import com.ensolution.ensol.common.data.repository.StackMeasurementRepository;
import com.ensolution.ensol.common.data.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExcelDataUploadService {
  StackMapper stackMapper;
  StackRepository stackRepository;
  PollutantMapper pollutantMapper;
  PollutantRepository pollutantRepository;
  StackMeasurementMapper stackMeasurementMapper;
  StackMeasurementRepository stackMeasurementRepository;

  public void addStackMeasurement(Integer workplaceId, List<ExcelStackMeasurementDto> excelData) {
    for (ExcelStackMeasurementDto item : excelData) {
      item.setWorkplace_id(workplaceId);

      StackMeasurementDto stackMeasurementDto = new StackMeasurementDto();

      Optional<Stack> stack = stackRepository.findByStackName(item.getStack_name());
      Optional<Pollutant> pollutant = pollutantRepository.findByPollutantNameKR(item.getPollutant_name());
      if (stack.isPresent() && pollutant.isPresent()) {
        stackMeasurementDto.setStackId(stackMapper.toDto(stack.get()).getStackId());
        stackMeasurementDto.setPollutantId(pollutantMapper.toDto(pollutant.get()).getPollutantId());
        stackMeasurementDto.setCycleType(item.getCycle_type());
        stackMeasurementDto.setMeasured(!item.getCycle_type().equals("nomeasure"));
        stackMeasurementDto.setAllowValue(item.getAllow_value());
      }
      ;
      stackMeasurementRepository.save(stackMeasurementMapper.toEntity(stackMeasurementDto));
    }
  }
}
