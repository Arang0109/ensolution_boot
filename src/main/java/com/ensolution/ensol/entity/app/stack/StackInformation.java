package com.ensolution.ensol.entity.app.stack;

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
  @Column(name = "gas_temperature")
  private Integer gasTemperature;
  private Double quantity;
  @Column(name = "height")
  private Double height;
  @Column(name = "stack_shape")
  private String stackShape;

  @OneToOne
  @MapsId
  @JoinColumn(name = "stack_id")
  private Stack stack;
}
