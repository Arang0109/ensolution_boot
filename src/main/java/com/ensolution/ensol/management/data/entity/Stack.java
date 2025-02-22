package com.ensolution.ensol.management.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "stack")
@Getter
@Setter
public class Stack {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stack_id", nullable = false)
  private int stackId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workplace_id", nullable = false)
  private Workplace workplace;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "factory_id")
  private Factory factory;
  @Column(name = "stack_name", nullable = false)
  private String stackName;
  @Column(name = "prevention")
  private String prevention;
  @Column(name = "note")
  private String note;
  @Column(name = "reg_date")
  private LocalDate regDate;
}
