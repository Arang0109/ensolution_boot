package com.ensolution.ensol.management.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "company")
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "company_id")
  private Integer id;
  @Column(name = "company_name", nullable = false)
  private String name;
  @Column(length = 45)
  private String address;
  @Column(name = "ceo_name")
  private String ceoName;
  @Column(name = "biz_number", nullable = false)
  private String bizNumber;
  @Column(name = "reg_date")
  private LocalDate regDate;
}