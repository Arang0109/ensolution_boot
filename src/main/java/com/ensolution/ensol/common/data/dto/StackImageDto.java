package com.ensolution.ensol.common.data.dto;

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
