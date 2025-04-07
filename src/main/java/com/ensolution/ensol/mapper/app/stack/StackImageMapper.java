package com.ensolution.ensol.mapper.app.stack;

import com.ensolution.ensol.dto.app.entity.stack.StackImageDto;
import com.ensolution.ensol.entity.app.stack.StackImage;
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
