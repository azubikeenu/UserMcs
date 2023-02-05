package com.azubike.ellipsis.usermcs.service.transaction;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionResponseDto;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto);
}
