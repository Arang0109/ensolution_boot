package com.ensolution.ensol.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseMessage<T> {
  private boolean success;
  private String message;
  private T data;
}
