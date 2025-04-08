package com.ensolution.ensol.mapper.auth;

import com.ensolution.ensol.dto.auth.UserDto;
import com.ensolution.ensol.entity.auth.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto toDto(User user);
  User toEntity(UserDto userDto);
}
