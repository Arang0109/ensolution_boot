package com.ensolution.ensol.management.controller;

import com.ensolution.ensol.common.service.ExcelDataUploadService;
import com.ensolution.ensol.management.domain.company.CompanyDto;
import com.ensolution.ensol.management.domain.company.WorkplaceDto;
import com.ensolution.ensol.management.domain.stack.*;
import com.ensolution.ensol.management.service.CompanyService;
import com.ensolution.ensol.management.service.StackMeasurementService;
import com.ensolution.ensol.management.service.StackService;
import com.ensolution.ensol.management.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${management.base}")
public class BusinessRestController {
  CompanyService companyService;
  WorkplaceService workplaceService;
  StackService stackService;
  StackMeasurementService stackMeasurementService;
  ExcelDataUploadService excelDataUploadService;

  @Autowired
  public BusinessRestController(CompanyService companyService, WorkplaceService workplaceService,
                                StackService stackService, StackMeasurementService stackMeasurementService,
                                ExcelDataUploadService excelDataUploadService) {
    this.companyService = companyService;
    this.workplaceService = workplaceService;
    this.stackService = stackService;
    this.stackMeasurementService = stackMeasurementService;
    this.excelDataUploadService = excelDataUploadService;
  }

  @DeleteMapping("${management.companies}")
  public void deleteCompany(@RequestBody List<CompanyDto> companies) {
    companyService.removeCompanies(companies);
  }

  @DeleteMapping("${management.workplaces}")
  public void deleteWorkplace(@RequestBody List<WorkplaceDto> workplaces) {
    workplaceService.removeWorkplaces(workplaces);
  }

  @DeleteMapping("${management.stacks}")
  public void deleteStack(@RequestBody List<StackDto> stacks) {
    stackService.removeStacks(stacks);
  }

  // "${management.stacks}" + "/{stackId}" + "${management.measurements}"
  @GetMapping
      ("${management.stacks}" +
          "/{stackId}" +
          "${management.measurements}")
  public ResponseEntity<Map<String, Object>> getStackMeasurement(@PathVariable Integer stackId) {
    List<StackMeasurementDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);

    Map<String, Object> response = new HashMap<>();
    response.put("stackMeasurements", stackMeasurements);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping
      ("${management.stacks}" +
          "/{stackId}" +
          "${management.measurements}")
  public void deleteStackMeasurement(@PathVariable Integer stackId,
                                     @RequestBody List<StackMeasurementDto> stackMeasurements) {
    System.out.println("delete 수행.. stackId: " + stackId);
    stackMeasurementService.removeStackMeasurements(stackMeasurements);
  }

  @PatchMapping("${management.companies}")
  public void updateCompany(@RequestBody CompanyDto companyDto) {
    companyService.updateCompany(companyDto);
  }

  @PatchMapping("${management.workplaces}")
  public void updateWorkplace(@RequestBody WorkplaceDto workplaceDto) { workplaceService.updateWorkplace(workplaceDto); }

  @PatchMapping("${management.stacks}")
  public void updateStack(@RequestBody StackDto stackDto) { stackService.updateStack(stackDto); }

  @PatchMapping
      ("${management.stacks}" +
          "/{stackId}" +
          "${stacks.information}")
  public void updateStackInfo(@PathVariable Integer stackId,
                              @RequestBody StackInformationDto stackInfoDto) {
    stackService.updateStackInfo(stackInfoDto, stackId);
  }

  @PostMapping
      ("${management.stacks}" +
          "/{stackId}" +
          "${management.measurements}")
  public void addStackMeasurement(@RequestBody List<StackMeasurementDto> stackMeasurementList) {
    for (StackMeasurementDto stackMeasurementDto : stackMeasurementList) {
      stackMeasurementService.addNewStackMeasurement(stackMeasurementDto);
    }
  }

  @PostMapping
      ("${management.workplaces}" +
          "/{workplaceId}" +
          "${upload.excel}")
  public void addExcelDataMeasurement(@PathVariable Integer workplaceId, @RequestBody List<ExcelStackMeasurementDto> exDataDto) {
    excelDataUploadService.addStackMeasurement(exDataDto);
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
