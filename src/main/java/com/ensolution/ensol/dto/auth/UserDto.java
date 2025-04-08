package com.ensolution.ensol.dto.auth;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
  private Integer userId;
  private String username;
  private String password;
  private boolean enabled;
}
