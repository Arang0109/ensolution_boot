package com.ensolution.ensol.entity.app.stack;

import com.ensolution.ensol.entity.app.company.Factory;
import com.ensolution.ensol.entity.app.company.Workplace;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "stack")
@Getter
@Setter
public class Stack {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stack_id", nullable = false)
  private Integer stackId;
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

  @OneToOne(mappedBy = "stack",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private StackInformation stackInformation;
  @JsonIgnore
  @OneToMany(mappedBy = "stack")
  private List<StackImage> stackImages;
  @OneToMany(mappedBy = "stack")
  private List<StackMeasurement> stackMeasurements;
}
