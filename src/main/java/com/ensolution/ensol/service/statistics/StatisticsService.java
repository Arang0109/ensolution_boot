package com.ensolution.ensol.service.statistics;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
  Map<String, Integer> getCompleteStackCnt();

  Map<String, Integer> getNonCompleteStackCnt();

  Map<String, Integer> getCompleteStackCntOfWorkplace(List<Integer> workplace_ids);

  Map<String, Integer> getNonCompleteStackCntOfWorkplace(List<Integer> workplace_ids);
}
