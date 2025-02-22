package com.ensolution.ensol.document.service;

import com.ensolution.ensol.common.data.dto.stack.PollutantDto;

import java.util.List;

public interface DocumentService {
  List<PollutantDto> selectPollutlantsList(List<PollutantDto> pollutantDto);
}
