package com.azubike.ellipsis.usermcs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@Data
@AllArgsConstructor
public class UserDto {
  @With private Integer id;
  private String name;
  private Integer balance;

  public UserDto() {}
}
