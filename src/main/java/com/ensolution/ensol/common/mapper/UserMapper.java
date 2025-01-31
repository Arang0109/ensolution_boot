package com.ensolution.ensol.common.mapper;

import com.ensolution.ensol.common.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  UserDto findByUsername(String username);
}
