package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.domain.StackDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.service.management.CompanyService;
import com.ensolution.ensol.service.management.StackService;
import com.ensolution.ensol.service.management.WorkplaceService;
import com.ensolution.ensol.service.pollutant.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    Integer company_id = workplace.getCompany_id();
    m.addAttribute("stacks", stackService.findStacksByWorkplaceId(workplaceId));
    m.addAttribute("company", companyService.findCompanyById(company_id));
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
    try {
      companyService.addNewCompany(companyDto);
      setFlashAttributes(rattr, "success",
          companyDto.getCompany_name() + " added successfully", null);
    } catch (DuplicateKeyException e) {
      setFlashAttributes(rattr, "error", null, "already exist");
    }
    return "redirect:/management/company";
  }

  @PostMapping("/workplace/add")
  public String addWorkplace(WorkplaceDto workplaceDto, RedirectAttributes rattr) {
    try {
      workplaceService.addNewWorkplace(workplaceDto);
      setFlashAttributes(rattr, "success",
          workplaceDto.getWorkplace_name() + " added successfully", null);
    } catch (DuplicateKeyException e) {
      setFlashAttributes(rattr, "error", null, "already exist");
    }
    return "redirect:/management/company/" + workplaceDto.getCompany_id();
  }

  @PostMapping("/stack/add")
  public String addStack(StackDto stackDto, RedirectAttributes rattr) {
    try {
      stackService.addNewStack(stackDto);
      setFlashAttributes(rattr, "success",
          stackDto.getStack_name() + " added successfully", null);
    } catch (DuplicateKeyException e) {
      setFlashAttributes(rattr, "error", null, "already exist");
    }
    return "redirect:/management/workplace/" + stackDto.getWorkplace_id();
  }

  private void setFlashAttributes(RedirectAttributes rattr,
                                  String result, String successMsg, String errorMsg) {
    rattr.addFlashAttribute("result", result);
    if (successMsg != null) {
      rattr.addFlashAttribute("successMsg", successMsg);
    }
    if (errorMsg != null) {
      rattr.addFlashAttribute("errorMsg", errorMsg);
    }
  }
}
