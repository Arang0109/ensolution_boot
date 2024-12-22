package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.service.management.CompanyService;
import com.ensolution.ensol.service.management.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management")
public class businessRestController {
  CompanyService companyService;
  WorkplaceService workplaceService;

  @Autowired
  public businessRestController(CompanyService companyService, WorkplaceService workplaceService) {
    this.companyService = companyService;
    this.workplaceService = workplaceService;
  }

  @DeleteMapping("/company/delete")
  public void deleteCompany(@RequestBody List<CompanyDto> companies) {
    companyService.removeCompanies(companies);
  }

  @DeleteMapping("/workplace/delete")
  public void deleteWorkplace(@RequestBody List<WorkplaceDto> workplaces) {
    workplaceService.removeWorkplaces(workplaces);
  }

  @PatchMapping("/company/modify")
  public void updateCompany(@RequestBody CompanyDto companyDto) {
    companyService.updateCompany(companyDto);
  }
}
