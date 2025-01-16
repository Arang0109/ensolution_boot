package com.ensolution.ensol.common.util;

import com.ensolution.ensol.management.domain.stack.PollutantDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CapabilityScoreCalculator {
  private List<PollutantDto> pollutants;

  private int gasCnt = 0;
  private boolean existDust;
  private boolean existMetal;
  private boolean existAs;
  private boolean existHg;
  private boolean existEtc;
  private boolean existG3;
  private double result;

  public CapabilityScoreCalculator() {}

  public CapabilityScoreCalculator(List<PollutantDto> pollutants) {
    this.pollutants = pollutants;

    this.existDust = existPollutant(pollutants, "먼지");
    this.existMetal = existPollutant(pollutants, "중금속");
    this.existAs = existPollutant(pollutants, "비소");
    this.existHg = existPollutant(pollutants, "수은");
    this.existEtc = existPollutant(pollutants, "기타");
    this.existG3 = existPollutant(pollutants);
    this.gasCnt = gasPollutantCnt(pollutants);
  }

  public Map<String, String> getScore() {
    Map<String, String> score = new HashMap<>();

    if (onlyExistEtc()) {
      this.result = PollutantScoreConstants.G3_SCORE;
      score.put("score", scoreFormatter(this.result));
      return score;
    }


    calculateGas();
    calculateParticle();

    score.put("score", scoreFormatter(this.result));
    return score;
  }

  // 입자상 물질 점수 산정 (먼지, 중금속, 비소, 수은)
  private void calculateParticle() {
    // Check existed dust
    if (existDust) this.result += PollutantScoreConstants.DUST_SCORE;
    if (existMetal) { // Check existed metal
      this.result += existDust ?
          PollutantScoreConstants.METAL_SCORE - PollutantScoreConstants.PARTICLE_DELTA : PollutantScoreConstants.METAL_SCORE;
    }
    if (existAs) { // Check existed As
      this.result += PollutantScoreConstants.AS_SCORE;
      if ((existDust && existMetal) || (existDust || existMetal)) {
        this.result -= PollutantScoreConstants.PARTICLE_DELTA;
      }
    }
    if (existHg) { // Check existed Hg
      this.result += PollutantScoreConstants.HG_SCORE;
      if (existDust || existMetal || existAs) this.result -= PollutantScoreConstants.HG_DELTA;
    }
    if (existEtc) this.result += PollutantScoreConstants.ETC_SCORE; // Check existed Etc
  }

  private void getGasScore(double score, double delta) {
    this.result += (!existDust && !existMetal && !existAs && !existHg && !existEtc) ?
        score : score - delta;
  }

  private void calculateGas() {
    if (gasCnt == 0) return;
    if (gasCnt >= 3) {
      getGasScore(PollutantScoreConstants.G1_SCORE, PollutantScoreConstants.G1_DELTA);
    } else {
      getGasScore(PollutantScoreConstants.G2_SCORE, PollutantScoreConstants.G2_DELTA);
    }
  }

  private boolean onlyExistEtc() {
    return !this.existDust && gasCnt == 0 && !this.existMetal && !this.existAs && !this.existHg && this.existG3;
  }

  private boolean existPollutant(List<PollutantDto> pollutants, String method) {
    return pollutants.stream()
        .anyMatch(p -> p.getMethod().equals(method));
  }

  private boolean existPollutant(List<PollutantDto> pollutants) {
    return pollutants.stream()
        .anyMatch(p -> PollutantScoreConstants.G3_LIST.contains(p.getMethod()));
  }

  private Integer gasPollutantCnt(List<PollutantDto> pollutants) {
    return (int) IntStream.range(0, pollutants.size())
        .filter(i -> {
          String method = pollutants.get(i).getMethod();
          return method.equals("흡수액");
        })
        .count();
  }

  private String scoreFormatter(double result) {
    return String.format("%.1f", result);
  }

  public List<PollutantDto> getPollutants() {
    return pollutants;
  }

  public int getGasCnt() {
    return gasCnt;
  }

  public boolean isExistDust() {
    return existDust;
  }

  public boolean isExistMetal() {
    return existMetal;
  }

  public boolean isExistAs() {
    return existAs;
  }

  public boolean isExistHg() {
    return existHg;
  }

  public boolean isExistEtc() {
    return existEtc;
  }

  public boolean isExistG3() {
    return existG3;
  }

  public double getResult() {
    return result;
  }

  @Override
  public String toString() {
    return "AbilityScore{" +
        "gasCnt=" + gasCnt +
        ", existDust=" + existDust +
        ", existMetal=" + existMetal +
        ", existAs=" + existAs +
        ", existHg=" + existHg +
        ", existEtc=" + existEtc +
        ", existG3=" + existG3 +
        ", result=" + result +
        ", pollutants=" + pollutants +
        '}';
  }
}
