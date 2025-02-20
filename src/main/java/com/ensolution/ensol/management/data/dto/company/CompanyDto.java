package com.ensolution.ensol.management.data.dto.company;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDto {
  private Integer id;
  private String name;
  private String address;
  private String ceoName;
  private String bizNumber;
  private LocalDate regDate;
}