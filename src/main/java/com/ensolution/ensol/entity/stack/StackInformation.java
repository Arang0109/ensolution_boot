package com.ensolution.ensol.entity.stack;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stack_info")
@Getter
@Setter
public class StackInformation {
  @Id
  @Column(name = "stack_id", nullable = false)
  private Integer stackId;
  private Double diameter;
  @Column(name = "dynamic_pressure")
  private Double dynamicPressure;
  @Column(name = "static_pressure")
  private Double staticPressure;
  private Double velocity;
  private Double quantity;
  private Double temperature;

  @OneToOne
  @MapsId
  @JoinColumn(name = "stack_id")
  private Stack stack;
}
