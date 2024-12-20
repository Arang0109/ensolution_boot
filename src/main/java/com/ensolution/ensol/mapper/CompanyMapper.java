package com.ensolution.ensol.mapper;

import com.ensolution.ensol.domain.CompanyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
  List<CompanyDto> selectAll();
  CompanyDto selectOne(Integer id);
  Integer insert(CompanyDto company);
}
