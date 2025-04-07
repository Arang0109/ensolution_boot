package com.ensolution.ensol.dto.app.entity.stack;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StackImageDto {
  private Integer stackImageId;
  private Integer stackId;
  private String imagePath;
  private String imageName;
}
