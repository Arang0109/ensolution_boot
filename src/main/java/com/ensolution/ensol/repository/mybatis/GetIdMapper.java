package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.TableIdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GetIdMapper {
  TableIdDto getIds(Integer id);
}
