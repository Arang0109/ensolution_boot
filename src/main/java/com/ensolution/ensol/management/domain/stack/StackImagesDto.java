package com.ensolution.ensol.management.domain.stack;


public class StackImagesDto {
  private Integer stack_images_id;
  private Integer stack_id;
  private String image_path;
  private String image_name;

  public StackImagesDto() {}

  public StackImagesDto(Integer stack_images_id, Integer stack_id, String image_path, String image_name) {
    this.stack_images_id = stack_images_id;
    this.stack_id = stack_id;
    this.image_path = image_path;
    this.image_name = image_name;
  }

  public Integer getStack_images_id() {
    return stack_images_id;
  }

  public void setStack_images_id(Integer stack_images_id) {
    this.stack_images_id = stack_images_id;
  }

  public Integer getStack_id() {
    return stack_id;
  }

  public void setStack_id(Integer stack_id) {
    this.stack_id = stack_id;
  }

  public String getImage_path() {
    return image_path;
  }

  public void setImage_path(String image_path) {
    this.image_path = image_path;
  }

  public String getImage_name() {
    return image_name;
  }

  public void setImage_name(String image_name) {
    this.image_name = image_name;
  }

  @Override
  public String toString() {
    return "StackImagesDto{" +
        "stack_images_id=" + stack_images_id +
        ", stack_id=" + stack_id +
        ", image_path='" + image_path + '\'' +
        ", image_name='" + image_name + '\'' +
        '}';
  }
}
