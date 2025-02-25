package com.ensolution.ensol.controller.management;

import com.ensolution.ensol.dto.entity.company.CompanyDto;
import com.ensolution.ensol.dto.entity.company.WorkplaceDto;
import com.ensolution.ensol.dto.entity.stack.StackDto;
import com.ensolution.ensol.dto.entity.stack.StackImageDto;
import com.ensolution.ensol.dto.entity.stack.StackInformationDto;
import com.ensolution.ensol.dto.entity.stack.StackMeasurementDto;
import com.ensolution.ensol.dto.query.ExcelStackMeasurementDto;
import com.ensolution.ensol.dto.query.table.StackMeasurementTableDto;
import com.ensolution.ensol.service.document.impl.ExcelDataUploadService;
import com.ensolution.ensol.service.company.CompanyService;
import com.ensolution.ensol.service.stack.StackMeasurementService;
import com.ensolution.ensol.service.stack.StackService;
import com.ensolution.ensol.service.company.WorkplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management")
@RequiredArgsConstructor
public class BusinessRestController {
  private final CompanyService companyService;
  private final WorkplaceService workplaceService;
  private final StackService stackService;
  private final StackMeasurementService stackMeasurementService;
  private final ExcelDataUploadService excelDataUploadService;

  @DeleteMapping("/companies")
  public void deleteCompanies(@RequestBody List<CompanyDto> companies) {
    companyService.removeCompanies(companies);
  }

  @DeleteMapping("/workplaces")
  public void deleteWorkplaces(@RequestBody List<WorkplaceDto> workplaces) {
    workplaceService.removeWorkplaces(workplaces);
  }

  @DeleteMapping("/stacks")
  public void deleteStacks(@RequestBody List<StackDto> stacks) {
    stackService.removeStacks(stacks);
  }

  @GetMapping
      ("/stacks/{stackId}/stack-measurements")
  public ResponseEntity<Map<String, Object>> getStackMeasurements(@PathVariable Integer stackId) {
    List<StackMeasurementTableDto> stackMeasurements = stackMeasurementService.findStackMeasurementsByStackId(stackId);
    Map<String, Object> response = new HashMap<>();
    response.put("stackMeasurements", stackMeasurements);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping
      ("/stacks/{stackId}/stack-measurements")
  public void deleteStackMeasurements(@PathVariable Integer stackId,
                                     @RequestBody List<StackMeasurementDto> stackMeasurements) {
    stackMeasurementService.removeStackMeasurements(stackMeasurements);
  }

  @PatchMapping("/companies/{companyId}")
  public void updateCompany(@PathVariable Integer companyId, @RequestBody CompanyDto companyDto) {
    companyDto.setCompanyId(companyId);
    companyService.updateCompany(companyDto);
  }

  @PatchMapping("/workplaces/{workplaceId}")
  public void updateWorkplace(@PathVariable Integer workplaceId, @RequestBody WorkplaceDto workplaceDto) {
    workplaceDto.setWorkplaceId(workplaceId);
    workplaceService.updateWorkplace(workplaceDto);
  }

  @PatchMapping("/stacks/{stackId}")
  public void updateStack(@PathVariable Integer stackId, @RequestBody StackDto stackDto) {
    stackDto.setStackId(stackId);
    stackService.updateStack(stackDto);
  }

  @PatchMapping("/stacks/{stackId}/info")
  public void updateStackInformation(@PathVariable Integer stackId,
                              @RequestBody StackInformationDto stackInfoDto) {
    stackService.updateStackInfo(stackInfoDto, stackId);
  }

  @PatchMapping("/stacks/{stackId}/note")
  public void updateStackNote(@PathVariable Integer stackId, @RequestBody String note) {
    StackDto stackDto = stackService.findStackById(stackId);
    stackDto.setNote(note);
    stackService.updateStack(stackDto);
  }

  @PostMapping
      ("/stacks/{stackId}/stack-measurements")
  public void createStackMeasurements(@PathVariable Integer stackId, @RequestBody List<StackMeasurementDto> stackMeasurementList) {
    for (StackMeasurementDto stackMeasurementDto : stackMeasurementList) {
      stackMeasurementDto.setStackId(stackId);
      stackMeasurementService.createStackMeasurement(stackMeasurementDto);
    }
  }

  @PostMapping
      ("/workplaces/{workplaceId}/upload/excel")
  public void uploadExcelDataMeasurements(@PathVariable Integer workplaceId, @RequestBody List<ExcelStackMeasurementDto> exDataDto) {
    excelDataUploadService.addStackMeasurement(workplaceId, exDataDto);
  }

  @GetMapping
      ("/stacks/{stackId}/images")
  public ResponseEntity<List<StackImageDto>> getStackImages(@PathVariable Integer stackId) {
    List<StackImageDto> images = stackService.findAllStackImages(stackId);
    return ResponseEntity.ok(images);
  }
}
