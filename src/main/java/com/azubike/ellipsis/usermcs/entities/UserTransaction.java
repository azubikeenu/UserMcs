package com.azubike.ellipsis.usermcs.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class UserTransaction {
  @Id private Integer id;
  private Integer userId;
  private Integer amount;
  private LocalDateTime transactionTime;
}
