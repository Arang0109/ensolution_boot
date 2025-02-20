package com.ensolution.ensol.management.data.mapper;

import com.ensolution.ensol.management.data.dto.stack.StackImagesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StackImagesMapper {
  StackImagesDto selectStackImage(Integer stack_images_id);
  List<StackImagesDto> selectAllImagesByStackId(Integer stack_id);
  Integer insert(StackImagesDto stackImage);
}
