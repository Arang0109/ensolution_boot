package com.ensolution.ensol.common.data.dto;

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
  private String method;
  private String samplingTime;
  private String samplingVolume;
}
