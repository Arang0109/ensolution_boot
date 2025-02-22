package com.ensolution.ensol.common.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "schedule_id", nullable = false)
  private Integer scheduleId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name= "stack_measurement_id", nullable = false)
  private StackMeasurement stackMeasurement;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id", nullable = false)
  private Team team;
  @Column(name = "measure_date")
  private LocalDate measureDate;
  @Column(name = "is_completed")
  private Boolean isCompleted;
  @Column(name = "reg_date")
  private LocalDate regDate;
}
