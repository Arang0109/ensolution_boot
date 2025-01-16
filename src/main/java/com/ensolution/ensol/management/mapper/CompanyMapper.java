package com.ensolution.ensol.management.mapper;

import com.ensolution.ensol.management.domain.company.CompanyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
  List<CompanyDto> selectAll();
  CompanyDto selectOne(Integer company_id);
  Integer insert(CompanyDto company);
  Integer update(CompanyDto company);
  Integer deleteItems(List<Integer> ids);
}
