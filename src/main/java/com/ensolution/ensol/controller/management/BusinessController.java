package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.dto.app.query.IdentityDto;
import com.ensolution.ensol.common.util.DataHandler;
import com.ensolution.ensol.dto.app.entity.company.CompanyDto;
import com.ensolution.ensol.dto.app.entity.stack.StackDto;
import com.ensolution.ensol.dto.app.entity.company.WorkplaceDto;
import com.ensolution.ensol.service.company.CompanyService;
import com.ensolution.ensol.service.stack.StackService;
import com.ensolution.ensol.service.company.WorkplaceService;
import com.ensolution.ensol.service.pollutant.PollutantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Optional;

@Controller
@RequestMapping("/management")
@RequiredArgsConstructor
public class BusinessController {
  private final CompanyService companyService; // 측정대행 의뢰업체 관련 로직 처리
  private final WorkplaceService workplaceService; // 측정대상 사업장 관련 로직 처리
  private final StackService stackService; // 측정 시설과 관련 로직 처리
  private final PollutantService pollutantService; // 측정 오염물질 관련 로직 처리

  /** 측정대행 의뢰업체 목록 */
  @GetMapping("/companies")
  public String getCompanyList(Model m) {
    m.addAttribute("companies", companyService.findAllCompanies());
    return "management/company/companyListView";
  }

  /** 측정대행 의뢰업체 추가 */
  @PostMapping("/companies")
  public String createCompany(CompanyDto companyDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
        companyDto,
        companyService::createCompany,
        rattr,
        companyDto.getCompanyName()
    );
    return "redirect:/management/companies";
  }

  /** 측정대행 의뢰업체 상세페이지 */
  @GetMapping
      ("/companies/{companyId}")
  public String getCompanyDetail(@PathVariable Integer companyId, Model m) {
    Optional<CompanyDto> company = companyService.findCompanyById(companyId);

    if (company.isPresent()) {
      m.addAttribute("workplaces", workplaceService.findWorkplacesByCompanyId(companyId));
      m.addAttribute("company", company.get());
    } else {
      return "redirect:/management/companies";
    }

    return "management/company/companyDetailView";
  }

  /** 사업장 목록 조회, 사업장 상세페이지 이동 링크 제공 */
  @GetMapping("/workplaces")
  public String getWorkplaceList(Model m) {
    m.addAttribute("workplaces", workplaceService.findAllWorkplaces());
    return "management/workplace/workplaceListView";
  }

  /** 측정대상 사업장 추가 */
  @PostMapping("/workplaces")
  public String createWorkplace(WorkplaceDto workplaceDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
        workplaceDto,
        workplaceService::createWorkplace,
        rattr,
        workplaceDto.getWorkplaceName()
    );
    return MessageFormat.format("redirect:/management/companies/{0}",
        workplaceDto.getCompanyId());
  }

  /** 사업장 상세페이지 */
  @GetMapping
      ("/workplaces/{workplaceId}")
  public String getWorkplaceDetail(@PathVariable Integer workplaceId, Model m) {
    Optional<WorkplaceDto> workplace = workplaceService.findWorkplaceById(workplaceId);
    if (workplace.isPresent()) {
      Integer companyId = workplace.get().getCompanyId();
      m.addAttribute("workplace", workplace.get());
      m.addAttribute("stacks", stackService.findStacksByWorkplaceId(workplaceId));
      m.addAttribute("company", companyService.findCompanyById(companyId).get());
    } else {
      return "redirect:/management/workplaces";
    }
    return "management/workplace/workplaceDetailView";
  }

  /** 시설 목록 조회, 시설 상세페이지 이동 링크 제공 */
  @GetMapping("/stacks")
  public String getStackList(Model m) {
    m.addAttribute("stacks", stackService.findStacksOfTable());
    return "management/stack/stackListView";
  }

  /** 새로운 시설 추가 */
  @PostMapping("/stacks")
  public String createStack(StackDto stackDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
        stackDto,
        stackService::createStack,
        rattr,
        stackDto.getStackName()
    );

    return MessageFormat.format("redirect:/management/workplaces/{0}",
        stackDto.getWorkplaceId());
  }

  /** 시설 상세페이지 */
  @GetMapping
      ("/stacks/{stackId}")
  public String getStackDetail(@PathVariable Integer stackId, Model m) {
    StackDto stack = stackService.findStackById(stackId);
    IdentityDto ids = stackService.findIds(stackId);
    WorkplaceDto workplace = workplaceService.findWorkplaceById(ids.getWorkplaceId()).get();
    if (stack == null) {
      return "redirect:/management/stacks";
    }

    m.addAttribute("stack", stack);
    m.addAttribute("company", companyService.findCompanyById(ids.getCompanyId()).get());
    m.addAttribute("workplace", workplace);
    m.addAttribute("pollutants", pollutantService.findAllPollutants());

    return "management/stack/stackDetailView";
  }

  /** 스택 이미지 업로드 */
  @PostMapping
      ("stacks/{stackId}/images")
  public String uploadStackImage(@PathVariable Integer stackId, @RequestParam("file") MultipartFile file) {
    try {
      stackService.saveFile(file, stackId);
      return "redirect:/management/stacks/" + stackId;
    } catch (IOException e) {
      return "redirect:/management/stacks/" + stackId;
    }
  }
}
