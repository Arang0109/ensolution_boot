package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDto> selectAll();
  List<BoardDto> selectByWorkplace(List<Integer> workplace_ids);
}
