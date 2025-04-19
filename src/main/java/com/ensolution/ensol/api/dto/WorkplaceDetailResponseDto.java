package com.ensolution.ensol.api.dto;

import com.ensolution.ensol.dto.app.entity.company.WorkplaceDto;
import com.ensolution.ensol.dto.app.entity.stack.StackDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkplaceDetailResponseDto {
  private WorkplaceDto workplace;
  private List<StackDto> stacks;
}
