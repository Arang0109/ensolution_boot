package com.ensolution.ensol.entity.app.stack;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stack_image")
@Getter
@Setter
public class StackImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stack_image_id", nullable = false)
  private Integer stackImageId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stack_id", nullable = false)
  private Stack stack;
  @Column(name = "image_path")
  private String imagePath;
  @Column(name = "image_name")
  private String imageName;
}
