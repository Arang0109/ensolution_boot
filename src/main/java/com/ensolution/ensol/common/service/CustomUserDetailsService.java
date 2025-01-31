package com.ensolution.ensol.common.service;

import com.ensolution.ensol.common.domain.UserDto;
import com.ensolution.ensol.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserMapper userMapper;

  @Autowired
  CustomUserDetailsService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDto user = userMapper.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return User.withUsername(user.getUsername())
        .password(user.getPassword())
        .roles("USER")
        .build();
  }
}
