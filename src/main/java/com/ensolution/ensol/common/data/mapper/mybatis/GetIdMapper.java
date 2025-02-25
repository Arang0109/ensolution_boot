package com.ensolution.ensol.common.data.mapper.mybatis;

import com.ensolution.ensol.common.data.dto.stack.TableIdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GetIdMapper {
  TableIdDto getIds(Integer id);
}
