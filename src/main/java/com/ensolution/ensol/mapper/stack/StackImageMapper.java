package com.ensolution.ensol.mapper.stack;

import com.ensolution.ensol.dto.entity.stack.StackImageDto;
import com.ensolution.ensol.entity.stack.StackImage;
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
