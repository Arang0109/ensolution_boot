package com.ensolution.ensol.management.domain.company;

import java.util.Objects;

public class FactoryDto {
  private Integer factory_id;
  private Integer workplace_id;
  private String name;

  public FactoryDto() {}

  public FactoryDto(Integer factory_id, Integer workplace_id, String name) {
    this.factory_id = factory_id;
    this.workplace_id = workplace_id;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FactoryDto that = (FactoryDto) o;
    return Objects.equals(factory_id, that.factory_id) && Objects.equals(workplace_id, that.workplace_id) && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factory_id, workplace_id, name);
  }

  public Integer getFactory_id() {
    return factory_id;
  }

  public void setFactory_id(Integer factory_id) {
    this.factory_id = factory_id;
  }

  public Integer getWorkplace_id() {
    return workplace_id;
  }

  public void setWorkplace_id(Integer workplace_id) {
    this.workplace_id = workplace_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "FactoryDto{" +
        "factory_id=" + factory_id +
        ", workplace_id=" + workplace_id +
        ", name='" + name + '\'' +
        '}';
  }
}
