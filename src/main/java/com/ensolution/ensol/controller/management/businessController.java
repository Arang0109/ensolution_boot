package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.domain.CompanyDto;
import com.ensolution.ensol.domain.WorkplaceDto;
import com.ensolution.ensol.service.management.CompanyService;
import com.ensolution.ensol.service.management.WorkplaceService;
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
public class businessController {
  CompanyService companyService;
  WorkplaceService workplaceService;

  @Autowired
  public businessController(CompanyService companyService, WorkplaceService workplaceService) {
    this.companyService = companyService;
    this.workplaceService = workplaceService;
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
