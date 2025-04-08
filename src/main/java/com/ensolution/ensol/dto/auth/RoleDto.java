package com.ensolution.ensol.dto.auth;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoleDto {
  private Integer roleId;
  private String roleName;
}
