package com.ensolution.ensol.dashboard.mapper;

import com.ensolution.ensol.dashboard.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDto> selectAll();
  List<BoardDto> selectByWorkplace(List<Integer> workplace_ids);
}
