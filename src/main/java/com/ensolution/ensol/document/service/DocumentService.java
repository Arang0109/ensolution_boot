package com.ensolution.ensol.document.service;

import com.ensolution.ensol.management.domain.stack.PollutantDto;

import java.util.List;

public interface DocumentService {
  List<PollutantDto> selectPollutlantsList(List<PollutantDto> pollutantDto);
}
