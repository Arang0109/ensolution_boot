package com.ensolution.ensol.service.document.impl;

import com.ensolution.ensol.dto.app.entity.stack.StackMeasurementDto;
import com.ensolution.ensol.dto.app.query.ExcelStackMeasurementDto;
import com.ensolution.ensol.entity.app.Pollutant;
import com.ensolution.ensol.entity.app.stack.Stack;
import com.ensolution.ensol.mapper.app.PollutantMapper;
import com.ensolution.ensol.mapper.app.stack.StackMapper;
import com.ensolution.ensol.mapper.app.stack.StackMeasurementMapper;
import com.ensolution.ensol.repository.app.jpa.pollutant.PollutantRepository;
import com.ensolution.ensol.repository.app.jpa.stack.StackMeasurementRepository;
import com.ensolution.ensol.repository.app.jpa.stack.StackRepository;
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
