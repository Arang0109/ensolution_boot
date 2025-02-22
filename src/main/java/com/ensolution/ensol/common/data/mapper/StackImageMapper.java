package com.ensolution.ensol.common.data.mapper;

import com.ensolution.ensol.common.data.dto.StackImageDto;
import com.ensolution.ensol.common.data.entity.StackImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StackImageMapper {
  @Mapping(source = "stack.stackId", target = "stackId")
  StackImageDto toDto(StackImage stackImage);
  @Mapping(source = "stackId", target = "stack.stackId")
  StackImage toEntity(StackImageDto stackImageDto);
  List<StackImageDto> toDtoList(List<StackImage> stackImages);
}
