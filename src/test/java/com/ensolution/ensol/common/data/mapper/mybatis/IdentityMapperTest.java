package com.ensolution.ensol.common.data.mapper.mybatis;

import com.ensolution.ensol.dto.query.IdentityDto;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import com.ensolution.ensol.service.stack.impl.StackServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IdentityMapperTest {
  @Mock
  private StackServiceImpl stackService;

  @Test
  void getIds() {
    IdentityDto mockData = new IdentityDto(1, 1,4);

    when(stackService.findIds(4)).thenReturn(mockData);

    // 테스트 실행
    System.out.println(stackService.findIds(4)); // [1, 2, 3, 4] 출력 예상

    // 검증 (해당 메서드가 호출되었는지 체크)
    verify(stackService).findIds(4);
  }
}