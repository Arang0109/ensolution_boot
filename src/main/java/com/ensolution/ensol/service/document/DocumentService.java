package com.ensolution.ensol.service.document;

import com.ensolution.ensol.dto.entity.PollutantDto;

import java.util.List;

public interface DocumentService {
  List<PollutantDto> selectPollutlantsList(List<PollutantDto> pollutantDto);
}
