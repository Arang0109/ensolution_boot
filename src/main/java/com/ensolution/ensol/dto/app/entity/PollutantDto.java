package com.ensolution.ensol.dto.app.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PollutantDto {
  private Integer pollutantId;
  private String pollutantNameKR;
  private String pollutantNameEN;
  private String PollutantNameHyundai;
  private String method;
  private Integer samplingTime;
  private Integer samplingVolume;
  private String analysisEquipment;
  private String legislationNumber;
}
