package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.CompanyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
  List<CompanyDto> selectAll();
  CompanyDto selectOne(Integer company_id);
  Integer insert(CompanyDto company);
  Integer update(CompanyDto company);
  Integer delete(List<Integer> ids);
}
