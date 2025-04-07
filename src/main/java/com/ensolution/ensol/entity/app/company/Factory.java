package com.ensolution.ensol.entity.app.company;

import com.ensolution.ensol.entity.app.stack.Stack;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factory")
@Getter
@Setter
public class Factory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "factory_id", nullable = false)
  private Integer factoryId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workplace_id", nullable = false)
  private Workplace workplace;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;
  @Column(name = "factory_name", nullable = false)
  private String factoryName;
  @Column(name = "factory_category")
  private String factoryCategory;

  @JsonIgnore
  @OneToMany(mappedBy = "factory")
  private List<Manager> managers = new ArrayList<>();
  @JsonIgnore
  @OneToMany(mappedBy = "factory")
  private List<Stack> stacks = new ArrayList<>();
}
