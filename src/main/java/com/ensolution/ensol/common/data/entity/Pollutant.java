package com.ensolution.ensol.common.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pollutant")
@Getter
@Setter
public class Pollutant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pollutant_id", nullable = false)
  private Integer pollutantId;
  @Column(name = "pollutant_name_kr", nullable = false)
  private String pollutantNameKR;
  @Column(name = "pollutant_name_en")
  private String pollutantNameEN;
  private String method;
  @Column(name = "sampling_time")
  private String samplingTime;
  @Column(name = "sampling_volume")
  private String samplingVolume;

  @OneToMany(mappedBy = "pollutant")
  private List<StackMeasurement> stackMeasurements;
}
