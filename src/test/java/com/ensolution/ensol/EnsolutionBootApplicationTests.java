package com.ensolution.ensol;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.service.CompanyService;
import com.ensolution.ensol.service.StackService;
import com.ensolution.ensol.service.WorkplaceService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
class EnsolutionBootApplicationTests {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private WorkplaceService workplaceService;
	@Autowired
	private StackService stackService;

	@Test
	public void companyServiceTest() {
		CompanyDto companyDto = new CompanyDto();

		companyDto.setCompany_name("as");
		System.out.println(companyDto);
	}

	@Test
	public void workplaceServiceTest() {
		System.out.println(workplaceService.getWorkplacesOfCompany(2));
	}

	@Test
	public void stackServiceTest() {
		System.out.println(stackService.getStack(371));
	}
}
