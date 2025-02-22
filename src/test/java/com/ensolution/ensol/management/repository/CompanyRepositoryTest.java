package com.ensolution.ensol.management.repository;

import com.ensolution.ensol.common.data.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyRepositoryTest {
  @Autowired
  CompanyRepository companyRepository;
  @Test
  void findByName() {
    System.out.println(companyRepository.findAll());
  }
}