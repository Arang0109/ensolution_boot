package com.ensolution.ensol.api.controller;

import com.ensolution.ensol.dto.app.entity.stack.StackDto;
import com.ensolution.ensol.service.stack.StackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/management/stacks")
@RequiredArgsConstructor
public class StackController {

  private final StackService stackService;

  @Operation(
      summary = "배출 시설 목록 조회",
      description = "등록된 모든 시설 정보를 조회합니다."
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "정상 응답",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = StackDto.class))),
      @ApiResponse(responseCode = "500", description = "서버 오류")
  })
  @GetMapping()
  /*  측정대상 사업장 목록 조희 */
  public List<StackDto> getStackList() {

    return stackService.findAllStacks();

  }
}
