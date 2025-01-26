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
  public void deleteCompanies(@RequestBody List<CompanyDto> companies) {
    companyService.removeCompanies(companies);
  }

  @DeleteMapping("${management.workplaces}")
  public void deleteWorkplaces(@RequestBody List<WorkplaceDto> workplaces) {
    workplaceService.removeWorkplaces(workplaces);
  }

  @DeleteMapping("${management.stacks}")
  public void deleteStacks(@RequestBody List<StackDto> stacks) {
    stackService.removeStacks(stacks);
  }

  @GetMapping
      ("${management.stacks}" +
          "/{stackId}/stack-measurements")
  public ResponseEntity<Map<String, Object>> getStackMeasurement(@PathVariable Integer stackId) {
    List<StackMeasurementDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);

    Map<String, Object> response = new HashMap<>();
    response.put("stackMeasurements", stackMeasurements);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping
      ("${management.stacks}" +
          "/{stackId}/stack-measurements")
  public void deleteStackMeasurements(@PathVariable Integer stackId,
                                     @RequestBody List<StackMeasurementDto> stackMeasurements) {
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

  @PatchMapping("${management.stacks}" + "/{stackId}/info")
  public void updateStackInformation(@PathVariable Integer stackId,
                              @RequestBody StackInformationDto stackInfoDto) {
    stackService.updateStackInfo(stackInfoDto, stackId);
  }

  @PatchMapping("${management.stacks}" + "{stackId}/note")
  public void updateStackNote(@RequestBody StackDto stack) {
    StackDto stackDto = stackService.findStackById(stack.getStack_id());
    stackDto.setNote(stack.getNote());
    stackService.updateStack(stackDto);
  }

  @PostMapping
      ("${management.stacks}" +
          "/{stackId}/stack-measurements")
  public void addStackMeasurements(@PathVariable Integer stackId, @RequestBody List<StackMeasurementDto> stackMeasurementList) {
    for (StackMeasurementDto stackMeasurementDto : stackMeasurementList) {
      stackMeasurementDto.setStack_id(stackId);
      stackMeasurementService.addNewStackMeasurement(stackMeasurementDto);
    }
  }

  @PostMapping
      ("${management.workplaces}" +
          "/{workplaceId}/upload/excel")
  public void uploadExcelDataMeasurements(@PathVariable Integer workplaceId, @RequestBody List<ExcelStackMeasurementDto> exDataDto) {
    excelDataUploadService.addStackMeasurement(workplaceId, exDataDto);
  }

  @GetMapping
      ("${management.stacks}" +
          "/{stackId}/images")
  public ResponseEntity<List<StackImagesDto>> getStackImages(@PathVariable Integer stackId) {
    List<StackImagesDto> images = stackService.findAllStackImages(stackId);
    return ResponseEntity.ok(images);
  }
}
