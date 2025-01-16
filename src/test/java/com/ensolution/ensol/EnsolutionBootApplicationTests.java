package com.ensolution.ensol;

import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.service.CompanyService;
import com.ensolution.ensol.management.service.StackMeasurementService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.management.service.PollutantService;
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
  @Autowired
  private PollutantService pollutantService;
  @Autowired
  private StackMeasurementService stackMeasurementService;

	@Test
	public void companyServiceTest() {
		CompanyDto companyDto = new CompanyDto();

		companyDto.setCompany_name("as");
		System.out.println(companyDto);
	}

	@Test
	public void workplaceServiceTest() {
		System.out.println(workplaceService.findWorkplaceById(10));
	}

	@Test
	public void stackServiceTest() {
		System.out.println(stackService.findStacksByWorkplaceId(10));
	}

  @Test
  public void PollutantServiceTest() {
    System.out.println(pollutantService.findAllPollutants());
  }

  @Test
  public void stackMeasurementServiceTest() {
    System.out.println(stackMeasurementService.findStackMeasurementsByStackId(315));

  }
}
