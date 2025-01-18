package com.ensolution.ensol.management.controller;

import com.ensolution.ensol.common.util.DataHandler;
import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.domain.stack.StackDto;
import com.ensolution.ensol.management.domain.company.WorkplaceDto;
import com.ensolution.ensol.management.service.CompanyService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.management.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/management")
public class BusinessController {
  CompanyService companyService;
  WorkplaceService workplaceService;
  StackService stackService;
  PollutantService pollutantService;

  @Autowired
  public BusinessController(CompanyService companyService, WorkplaceService workplaceService,
                            StackService stackService, PollutantService pollutantService) {
    this.companyService = companyService;
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.pollutantService = pollutantService;
  }

  @GetMapping("/company")
  public String companyListView(Model m) {
    m.addAttribute("companies", companyService.findAllCompanies());
    return "management/company/companyListView";
  }

  @GetMapping("/workplace")
  public String workplaceListView(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    return "management/workplace/workplaceListView";
  }

  @GetMapping("/stack")
  public String stackListView(Model m) {
    m.addAttribute("stacks", stackService.findStacksOfTable());
    return "management/stack/stackListView";
  }

  @GetMapping("/company/{companyId}")
  public String companyDetailView(@PathVariable Integer companyId, Model m) {
    CompanyDto company = companyService.findCompanyById(companyId);
    if (company == null) {
      return "redirect:/management/company";
    }
    m.addAttribute("workplaces", workplaceService.findWorkplacesByCompanyId(companyId));
    m.addAttribute("company", company);
    return "management/company/companyDetailView";
  }

  @GetMapping("/workplace/{workplaceId}")
  public String workplaceDetailView(@PathVariable Integer workplaceId, Model m) {
    WorkplaceDto workplace = workplaceService.findWorkplaceById(workplaceId);
    if (workplace == null) {
      return "redirect:/management/workplace";
    }

    m.addAttribute("stacks", stackService.findStacksByWorkplaceId(workplaceId));
    m.addAttribute("company", companyService.findCompanyById(workplace.getCompany_id()));
    m.addAttribute("workplace", workplace);
    m.addAttribute("sub_factories", workplaceService.findSubFactoriesByWorkplaceId(workplaceId));
    m.addAttribute("departments", workplaceService.findDepartmentsByWorkplaceId(workplaceId));
    return "management/workplace/workplaceDetailView";
  }

  @GetMapping("/stack/{stackId}")
  public String stackDetailView(@PathVariable Integer stackId, Model m) {
    StackDto stack = stackService.findStackById(stackId);
    if (stack == null) {
      return "redirect:/management/stack";
    }
    m.addAttribute("company", companyService.findCompanyById(stackService.getCompanyWorkplaceId(stackId).get("company_id")));
    m.addAttribute("workplace", workplaceService.findWorkplaceById(stackService.getCompanyWorkplaceId(stackId).get("workplace_id")));
    m.addAttribute("stack", stack);
    m.addAttribute("pollutants", pollutantService.findAllPollutants());
    return "management/stack/stackDetailView";
  }

  @PostMapping("/company/add")
  public String addCompany(CompanyDto companyDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
        companyDto,
        companyService::addNewCompany,
        rattr,
        companyDto.getCompany_name()
    );
    return "redirect:/management/company";
  }

  @PostMapping("/workplace/add")
  public String addWorkplace(WorkplaceDto workplaceDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
      workplaceDto,
      workplaceService::addNewWorkplace,
      rattr,
      workplaceDto.getWorkplace_name()
    );
    return "redirect:/management/company/" + workplaceDto.getCompany_id();
  }

  @PostMapping("/stack/add")
  public String addStack(StackDto stackDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
      stackDto,
      stackService::addNewStack,
      rattr,
      stackDto.getStack_name()
    );
    return "redirect:/management/workplace/" + stackDto.getWorkplace_id();
  }
}
