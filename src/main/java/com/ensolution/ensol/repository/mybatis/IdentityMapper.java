package com.ensolution.ensol.repository.mybatis;

import com.ensolution.ensol.dto.query.IdentityDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdentityMapper {
  IdentityDto getIds(Integer id);
}
