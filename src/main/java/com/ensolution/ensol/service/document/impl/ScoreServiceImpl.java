package com.ensolution.ensol.service.document.impl;

import com.ensolution.ensol.domain.management.stack.PollutantDto;
import com.ensolution.ensol.service.document.ScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {
  @Override
  public Map abilityScoreCal(List<PollutantDto> pollutants) {
    int gasCnt = 0;
    boolean isDust = false;
    boolean isMetal = false;
    boolean isAs = false;
    boolean isHg = false;
    boolean isG3 = false;
    double score = 0.0;

    Map map = new HashMap();

    List<String> method = new ArrayList<>();
    for (PollutantDto p : pollutants) {
      if (p.getMethod().equals("흡수액")) { gasCnt++; }
      if (p.getMethod().equals("흡수액, 중금속")) { gasCnt++; isAs = true; }
      if (p.getMethod().equals("수은")) { isHg = true; }
      if (p.getMethod().equals("먼지")) { isDust = true; }
      if (!isMetal && p.getMethod().equals("중금속")) { isMetal = true; }
      if (!isG3 && p.getMethod().equals("현장측정") || p.getMethod().equals("카트리지") ||
          p.getMethod().equals("흡착관(T)") || p.getMethod().equals("흡착관(A)")) {
        isG3 = true;
      }
    }

    // G3 항목만 존재하는 경우 >> 0.3
    if (!isDust && !isMetal && !isAs && !isHg && gasCnt == 0 && isG3) {
      score = 0.3;
      map.put("score", String.format("%.1f", score));
      return map;
    }

    if (gasCnt > 0 && gasCnt < 3) {
      if (!isDust && !isMetal && !isHg) {
        score += 0.5;
      } else { score += 0.3; }
    } else if (gasCnt >= 3) {
      if (!isDust && !isMetal && !isAs && !isHg) {
        score += 1.0;
      } else { score += 0.5; }
    }

    if (isDust) {
      if (isMetal) {
        score += 1.9;
      } else {
        score += 1.0;
      }
    } else if (isMetal) {
      score += 1.3;
    }

    if (isAs) {
      if (!isMetal) {
        score += 1.0;
      }
    }

    if (isHg) {
      if (isDust || isMetal) {
        score += 1.0;
      } else {
        score += 1.2;
      }
    }

    map.put("score", String.format("%.1f", score));

    return map;
  }
}
