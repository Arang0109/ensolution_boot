package com.ensolution.ensol.common.service;

import com.ensolution.ensol.common.data.dto.stack.ExcelStackMeasurementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelDataUploadService {
  StackMapper stackMapper;
  PollutantMapper pollutantMapper;
  StackMeasurementMapper stackMeasurementMapper;

  @Autowired
  public ExcelDataUploadService(StackMapper stackMapper, PollutantMapper pollutantMapper,
                                StackMeasurementMapper stackMeasurementMapper) {
    this.stackMapper = stackMapper;
    this.pollutantMapper = pollutantMapper;
    this.stackMeasurementMapper = stackMeasurementMapper;
  }

  public void addStackMeasurement(Integer workplaceId, List<ExcelStackMeasurementDto> excelData) {
    for (ExcelStackMeasurementDto item : excelData) {
      item.setWorkplace_id(workplaceId);

      StackMeasurementDto stackMeasurementDto = new StackMeasurementDto();

      stackMeasurementDto.setStack_id(stackMapper.selectStackIdByName(item));
      stackMeasurementDto.setPollutant_id(pollutantMapper.selectPollutantIdByName(item.getPollutant_name()));
      stackMeasurementDto.setCycle_type(item.getCycle_type());
      stackMeasurementDto.setIs_measure(!item.getCycle_type().equals("nomeasure"));
      stackMeasurementDto.setAllow_value(item.getAllow_value());

      stackMeasurementMapper.insert(stackMeasurementDto);
    }
  }
}
