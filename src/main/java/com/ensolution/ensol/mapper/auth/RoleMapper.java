package com.ensolution.ensol.mapper.auth;

import com.ensolution.ensol.dto.auth.RoleDto;
import com.ensolution.ensol.entity.auth.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
  RoleDto toDto(Role role);
  Role toEntity(RoleDto roleDto);
}
