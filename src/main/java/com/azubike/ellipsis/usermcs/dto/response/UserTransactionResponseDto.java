package com.azubike.ellipsis.usermcs.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserTransactionResponseDto {
    private int userId ;
    private int amount ;
    private LocalDateTime transactionDate ;
}
