package com.ensolution.ensol.management.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "workplace")
@Getter
@Setter
public class Workplace {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "workplace_id", nullable = false)
  private Integer workplaceId;
  @ManyToOne
  @JoinColumn(name = "company_id" ,nullable = false)
  private Company company;
  @Column(name = "workplace_name", nullable = false)
  private String workplaceName;
  private String address;
  @Column(name = "exist_factory")
  private String existFactory;
  @Column(name = "reg_date")
  private LocalDate regDate;
}