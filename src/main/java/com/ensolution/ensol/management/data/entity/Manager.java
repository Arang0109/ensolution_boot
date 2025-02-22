package com.ensolution.ensol.management.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manager")
@Getter
@Setter
public class Manager {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "manager_id", nullable = false)
  private Integer managerId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "factory_id", nullable = false)
  private Factory factory;
  @Column(name = "manager_name", nullable = false)
  private String managerName;
  @Column(name = "manager_phone")
  private String managerPhone;
  @Column(name = "manager_position")
  private String managerPosition;
}
