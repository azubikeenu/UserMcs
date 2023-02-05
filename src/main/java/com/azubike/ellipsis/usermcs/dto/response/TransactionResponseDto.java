package com.azubike.ellipsis.usermcs.dto.response;

import lombok.Data;

@Data
public class TransactionResponseDto {
    private Integer userId ;
    private TransactionStatus status;
    private Integer amount ;
}
