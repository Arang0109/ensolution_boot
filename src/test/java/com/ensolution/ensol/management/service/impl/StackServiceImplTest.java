package com.ensolution.ensol.management.service.impl;

import com.ensolution.ensol.service.stack.StackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StackServiceImplTest {
  @Autowired
  StackService stackService;

  @Test
  void findStacksByWorkplaceId() {
    System.out.println(stackService.findStacksByWorkplaceId(1));
  }
}