package com.ensolution.ensol.common.url;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UrlConstantsTest {
  @Autowired
  UrlConstants urlConstants;

  @Test
  void getMANAGEMENT_BASE() {
    System.out.println(urlConstants.getMANAGEMENT_BASE());
  }

  @Test
  void getMANAGEMENT_URL() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    System.out.println(encoder.encode("test1234")); // 비밀번호를 BCrypt로 암호화
  }
}