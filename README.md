# ENSolution
환경 측정 대행 업체를 위한 대기, 수질, 악취 등 환경 측정 업무의 자동화 및 문서 관리 솔루션
## 주요 기능 *(개발 예정 기능 포함)*
1. 업체 데이터 관리
   1. 측정대행 의뢰업체 관리 (Company)
   2. 측정대상 사업장 관리 (Workplace)
   3. 측정시설 관리 (Stack)
   ![link](project-image/img1.PNG)
   ![link](project-image/img2.PNG)
   4. 측정항목 관리 (Stack_Measurement)
      1. 엑셀 데이터 업로드 기능
      ![link](project-image/img3.PNG)
   5. 측정 오염물질 주기 관리 (Pollutant)
2. 측정 일정 관리
   1. 일정 등록 기능
   2. 측정시설 및 측정항목의 주기별 완료 현황 확인
   3. 주기별 일정 초기화
3. 측정 데이터 통계 및 시각화
   1. 사업장 별 측정 완료 지점 수 시각화 차트
   ![link](project-image/img4.PNG)
   2. 매출 보고서 (**개발 예정**)
4. 용역이행능력평가 점수 계산
5. 문서 관리 (**개발 예정**)
   1. 품질 문서 관리
      1. 내부 장비 교정서
      2. 성적서
      3. 그 외 모든 문서
   2. 사내 문서 관리
      1. 차량운행일지
      2. 인수인계서
      3. 장비관리대장
      4. 여지관리대장
      5. 차량관리대장
      6. 그 외 모든 문서
### 기술 스택
- **프론트엔드:** HTML, CSS, JavaScript
- **백엔드:** Java, Spring Boot
- **데이터베이스:** MySQL
### 데이터베이스
| Table                 | Field                                                 | Foreign Key                              |
|-----------------------|-------------------------------------------------------|------------------------------------------|
| company               | id, name, address, ceo, biz_number, reg_date          |                                          |
| workplace             | id, name, address, reg_date                           | company_id                               |
| factory               | id, name                                              | workplace_id                             |
| sub_factory           | id, name                                              | factory_id                               |
| stack                 | id, name, prevention, note, reg_date                  | sub_factory_id, management_department_id |
| stack_info            | id, 필요 재원들                                            | stack_id                                 |
| stack_images          | id, name, image_data                                  | stack_id                                 |
| pollutant             | id, name, name_en, method                             |                                          |
| stack_measurement     | id, cycle_type, is_completed, is_measure, allow_value | stack_id, pollutant_id                   |
| schedule              | id, measure_date, is_completed                        | team_id, stack_measurement_id            |
| team                  | id, name                                              |                                          |
| management_department | id, name, tel                                         | workplace_id                             |
### RESTful API 설계
<table>
  <tr>
    <th>대상</th>
    <th>동작</th>
    <th>URL</th>
    <th>HTTP method</th>
  </tr>
  <tr>
    <td rowspan="5">company</td>
    <td>List all companies</td>
    <td rowspan="4">/companies</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>Create a company</td>
    <td>POST</td>
  </tr>
  <tr>
    <td>Modify a company</td>
    <td>PATCH</td>
  </tr>
  <tr>
    <td>Delete companies</td>
    <td>DELETE</td>
  </tr>
  <tr>
    <td>Get a specific company</td>
    <td>/companies/{company_id}</td>
    <td>GET</td>
  </tr>
  <tr>
    <td rowspan="6">workplace</td>
    <td>List all workplaces</td>
    <td rowspan="4">/workplaces</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>Create a workplace</td>
    <td>POST</td>
  </tr>
  <tr>
    <td>Modify a workplace</td>
    <td>PATCH</td>
  </tr>
  <tr>
    <td>Delete workplaces</td>
    <td>DELETE</td>
  </tr>
  <tr>
    <td>Get a specific workplace</td>
    <td>/workplaces/{workplace_id}</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>Create stack measurement By excel form</td>
    <td>/workplaces/{workplace_id}/upload/excel</td>
    <td>POST</td>
  </tr>
  <tr>
    <td rowspan="5">stack</td>
    <td>List all stacks</td>
    <td rowspan="4">/stacks</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>Create a stack</td>
    <td>POST</td>
  </tr>
  <tr>
    <td>Modify a stack</td>
    <td>PATCH</td>
  </tr>
  <tr>
    <td>Delete stacks</td>
    <td>DELETE</td>
  </tr>
  <tr>
    <td>Get a specific stack</td>
    <td>/stacks/{stack_id}</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>stack information</td>
    <td>Modify a stackInformation</td>
    <td>/stacks/{stack_id}/info</td>
    <td>POST</td>
  </tr>
  <tr>
    <td rowspan="3">stack measurement</td>
    <td>Get measurements of a specific stack</td>
    <td rowspan="3">/stacks/{stack_id}/measurements</td>
    <td>GET</td>
  </tr>
  <tr>
    <td>Create stack measurements</td>
    <td>POST</td>
  </tr>
  <tr>
    <td>Delete measurements of a specific stack</td>
    <td>DELETE</td>
  </tr>
</table>

### 준비 사항
1. Java Development Kit (JDK) 21
2. MySQL Database
- 기본 데이터베이스 이름 : ensolution
- git 프로젝트 > ensolution.sql 다운로드