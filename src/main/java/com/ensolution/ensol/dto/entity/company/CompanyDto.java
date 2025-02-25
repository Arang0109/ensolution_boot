package com.ensolution.ensol.dto.entity.company;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDto {
  private Integer companyId;
  private String companyName;
  private String address;
  private String ceoName;
  private String bizNumber;
  private LocalDate regDate;
}