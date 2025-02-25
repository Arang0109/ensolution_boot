package com.ensolution.ensol.entity.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id", nullable = false)
  private Integer departmentId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workplace_id", nullable = false)
  private Workplace workplace;
  @Column(name = "department_name", nullable = false)
  private String departmentName;
  @Column(name = "department_phone")
  private String departmentPhone;

  @JsonIgnore
  @OneToMany(mappedBy = "department")
  private List<Factory> factories = new ArrayList<>();
}
