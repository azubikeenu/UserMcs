package com.azubike.ellipsis.usermcs.service.transaction;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionResponseDto;
import com.azubike.ellipsis.usermcs.dto.response.UserTransactionResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto);
    Flux<UserTransactionResponseDto> getAllUserTransactions(int userId);
}
