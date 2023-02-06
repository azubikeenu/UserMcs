package com.azubike.ellipsis.usermcs.controllers;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionResponseDto;
import com.azubike.ellipsis.usermcs.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("users/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionService transactionService;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping
  public Mono<TransactionResponseDto> createTransaction(
      @RequestBody Mono<TransactionRequestDto> transactionRequestDto) {
    return transactionRequestDto.flatMap(transactionService::createTransaction);
  }
}
