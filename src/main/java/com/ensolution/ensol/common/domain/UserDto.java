package com.ensolution.ensol.common.domain;

import java.util.Objects;

public class UserDto {
  private String username;
  private String password;
  private String user_name;
  private String email;

  public UserDto(String username, String password, String user_name, String email) {
    this.username = username;
    this.password = password;
    this.user_name = user_name;
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserDto userDto = (UserDto) o;
    return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(user_name, userDto.user_name) && Objects.equals(email, userDto.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, user_name, email);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String user_pwd) {
    this.password = password;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "UserDto{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", user_name='" + user_name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
