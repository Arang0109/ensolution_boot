package com.ensolution.ensol.common.url;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlConstantsTest {
  @Autowired
  UrlConstants urlConstants;

  @Test
  void getMANAGEMENT_BASE() {
    System.out.println(urlConstants.getMANAGEMENT_BASE());
  }
}