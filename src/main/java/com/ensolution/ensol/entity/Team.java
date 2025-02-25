package com.ensolution.ensol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "team_id", nullable = false)
  private Integer teamId;
  @Column(name = "team_name", nullable = false)
  private String teamName;

  @JsonIgnore
  @OneToMany(mappedBy = "team")
  private List<Schedule> schedules;
}