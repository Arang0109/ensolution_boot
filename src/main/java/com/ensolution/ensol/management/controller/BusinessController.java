package com.ensolution.ensol.management.controller;

import com.ensolution.ensol.common.url.UrlConstants;
import com.ensolution.ensol.common.util.DataHandler;
import com.ensolution.ensol.management.data.dto.company.CompanyDto;
import com.ensolution.ensol.management.data.dto.stack.StackDto;
import com.ensolution.ensol.management.data.dto.company.WorkplaceDto;
import com.ensolution.ensol.management.service.CompanyService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import com.ensolution.ensol.management.service.PollutantService;
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
@RequestMapping("${management.base}")
@RequiredArgsConstructor
public class BusinessController {
  private final CompanyService companyService; // 측정대행 의뢰업체 관련 로직 처리
  private final WorkplaceService workplaceService; // 측정대상 사업장 관련 로직 처리
  private final StackService stackService; // 측정 시설과 관련 로직 처리
  private final PollutantService pollutantService; // 측정 오염물질 관련 로직 처리
  private final UrlConstants urlConstants;

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
      m.addAttribute("company", company);
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
      m.addAttribute("workplace", workplace);
      m.addAttribute("stacks", stackService.findStacksByWorkplaceId(workplaceId));
      m.addAttribute("company", companyService.findCompanyById(workplace.get().getCompanyId()));
    } else {
      return "redirect:/management/workplaces";
    }
    return "management/workplace/workplaceDetailView";
  }

  /** 시설 목록 조회, 시설 상세페이지 이동 링크 제공 */
  @GetMapping("${management.stacks}")
  public String getStackList(Model m) {
    m.addAttribute("stacks", stackService.findStacksOfTable());
    return "management/stack/stackListView";
  }

  /**
   * 새로운 시설 추가
   * `DataHandler.addOperationHandler`: 데이터 저장, 결과 메시지 관리, 예외 처리 수행
   *
   * @param stackDto 추가할 시설 정보를 담고 있는 객체
   * @param rattr 리다이렉트 시 전달할 메시지를 저장하는 객체
   * @return 시설 목록 페이지로 리다이렉트
   */
  @PostMapping("${management.stacks}")
  public String createStack(StackDto stackDto, RedirectAttributes rattr) {
    DataHandler.addOperationHandler(
        stackDto,
        stackService::createStack,
        rattr,
        stackDto.getStack_name()
    );
    return MessageFormat.format("redirect:{0}{1}/{2}",
        urlConstants.getMANAGEMENT_BASE(),
        urlConstants.getMANAGEMENT_WORKPLACES(),
        stackDto.getWorkplace_id());
  }

  /**
   * 시설 상세페이지
   * 시설 정보 수정 및 해당 시설의 측정 항목 제공
   * 측정 항목 추가 및 삭제 처리 지원
   *
   * @param stackId 측정 시설 ID
   * @param m Model 객체
   * 모델 데이터
   * - "stack" : 시설 정보 데이터 (stackService.findStackById(stackId))
   * - "company" : 업체 정보 데이터 (companyService.findCompanyById(stackService.getCompanyWorkplaceId(stackId).get("company_id")))
   * - "workplace" : 사업장 정보 데이터 (workplaceService.findWorkplaceById(stackService.getCompanyWorkplaceId(stackId).get("workplace_id")))
   * - "pollutants" : 오염물질 목록 데이터 (pollutantService.findAllPollutants())
   * @return 측정 시설 상세페이지
   */
  @GetMapping
      ("${management.stacks}" +
          "/{stackId}")
  public String getStackDetail(@PathVariable Integer stackId, Model m) {
    StackDto stack = stackService.findStackById(stackId);
    if (stack == null) {
      return MessageFormat.format("redirect:{0}{1}",
          urlConstants.getMANAGEMENT_BASE(),
          urlConstants.getMANAGEMENT_STACKS());
    }

    m.addAttribute("stack", stack);
    m.addAttribute("company", companyService.findCompanyById(stackService.getCompanyWorkplaceId(stackId).get("company_id")));
    m.addAttribute("workplace", workplaceService.findWorkplaceById(stackService.getCompanyWorkplaceId(stackId).get("workplace_id")));
    m.addAttribute("pollutants", pollutantService.findAllPollutants());
    return "management/stack/stackDetailView";
  }

  /**
   * 스택 이미지 업로드
   *
   * @param stackId 업로드할 스택의 ID
   * @param file 업로드할 파일
   * @return 업로드 후 스택 상세 페이지로 리다이렉트
   */
  @PostMapping
      ("${management.stacks}" +
          "/{stackId}/images")
  public String uploadStackImage(@PathVariable Integer stackId, @RequestParam("file") MultipartFile file) {
    try {
      stackService.saveFile(file, stackId);
      return "redirect:/management/stacks/" + stackId;
    } catch (IOException e) {
      return "redirect:/management/stacks/" + stackId;
    }
  }
}
