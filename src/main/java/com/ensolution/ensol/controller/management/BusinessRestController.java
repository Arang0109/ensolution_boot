package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.domain.management.company.CompanyDto;
import com.ensolution.ensol.domain.management.company.WorkplaceDto;
import com.ensolution.ensol.domain.management.stack.StackDto;
import com.ensolution.ensol.domain.management.stack.StackImagesDto;
import com.ensolution.ensol.domain.management.stack.StackInformationDto;
import com.ensolution.ensol.domain.management.stack.StackMeasurementDto;
import com.ensolution.ensol.service.management.CompanyService;
import com.ensolution.ensol.service.management.StackMeasurementService;
import com.ensolution.ensol.service.management.StackService;
import com.ensolution.ensol.service.management.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class BusinessRestController {
  CompanyService companyService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;

  @Autowired
  public BusinessRestController(CompanyService companyService, WorkplaceService workplaceService,
                                StackService stackService, StackMeasurementService stackMeasurementService) {
    this.companyService = companyService;
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
  }

  @GetMapping("/stack/getStackMeasurement")
  public ResponseEntity<Map<String, Object>> getStackMeasurement(@RequestParam Integer stackId) {
    List<StackMeasurementDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);

    Map<String, Object> response = new HashMap<>();
    response.put("stackMeasurements", stackMeasurements);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/company/delete")
  public void deleteCompany(@RequestBody List<CompanyDto> companies) {
    companyService.removeCompanies(companies);
  }

  @DeleteMapping("/workplace/delete")
  public void deleteWorkplace(@RequestBody List<WorkplaceDto> workplaces) {
    workplaceService.removeWorkplaces(workplaces);
  }

  @DeleteMapping("/stack/delete")
  public void deleteStack(@RequestBody List<StackDto> stacks) {
    stackService.removeStacks(stacks);
  }

  @DeleteMapping("/stack-measurement/delete")
  public void deleteStackMeasurement(@RequestBody List<StackMeasurementDto> stackMeasurements) {
    stackMeasurementService.removeStackMeasurements(stackMeasurements);
  }

  @PatchMapping("/company/modify")
  public void updateCompany(@RequestBody CompanyDto companyDto) {
    companyService.updateCompany(companyDto);
  }

  @PatchMapping("/workplace/modify")
  public void updateWorkplace(@RequestBody WorkplaceDto workplaceDto) { workplaceService.updateWorkplace(workplaceDto); }

  @PatchMapping("/stack/modify")
  public void updateStack(@RequestBody StackDto stackDto) { stackService.updateStack(stackDto); }

  @PatchMapping("/stack/modify/specification")
  public void updateStackInfo(@RequestBody StackInformationDto stackInfoDto) {
    stackService.updateStackInfo(stackInfoDto);
  }

  @PostMapping("/stack-measurement/add")
  public void addStackMeasurement(@RequestBody List<StackMeasurementDto> stackMeasurementList) {
    for (StackMeasurementDto stackMeasurementDto : stackMeasurementList) {
      stackMeasurementService.addNewStackMeasurement(stackMeasurementDto);
    }
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("stackId") Integer stackId) {
    try {
      stackService.saveFile(file, stackId);
      return ResponseEntity.ok("파일 업로드 성공");
    } catch (IOException e) {
      return ResponseEntity.status(500).body("파일 업로드 실패: " + e.getMessage());
    }
  }

  @GetMapping("/images")
  public ResponseEntity<List<StackImagesDto>> getImagesByStackId(@RequestParam Integer stackId) {
    List<StackImagesDto> images = stackService.findAllStackImages(stackId);
    return ResponseEntity.ok(images);
  }
}
