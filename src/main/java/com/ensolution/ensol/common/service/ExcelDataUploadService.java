package com.ensolution.ensol.common.service;

import com.ensolution.ensol.management.domain.stack.ExcelStackMeasurementDto;
import com.ensolution.ensol.management.mapper.PollutantMapper;
import com.ensolution.ensol.management.mapper.StackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelDataUploadService {
  StackMapper stackMapper;
  PollutantMapper pollutantMapper;

  @Autowired
  public ExcelDataUploadService(StackMapper stackMapper, PollutantMapper pollutantMapper) {
    this.stackMapper = stackMapper;
    this.pollutantMapper = pollutantMapper;
  }

  public void addStackMeasurement(List<ExcelStackMeasurementDto> excelData) {
    for (ExcelStackMeasurementDto item : excelData) {
      String pollutant_name = item.getPollutant_name();
      Integer stack_id = stackMapper.selectStackIdByName(item);
      Integer pollutant_id = pollutantMapper.selectPollutantIdByName(pollutant_name);

      System.out.println("stack_id : " + stack_id + " pollutant_id : " + pollutant_id);
      // 추가 : stack_measurement Table 에 insert
    }
  }
}
