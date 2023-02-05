package com.azubike.ellipsis.usermcs.service.transaction;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionResponseDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionStatus;
import com.azubike.ellipsis.usermcs.repository.UserRepository;
import com.azubike.ellipsis.usermcs.repository.UserTransactionRepository;
import com.azubike.ellipsis.usermcs.utils.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final UserRepository userRepository;
  private final UserTransactionRepository transactionRepository;

  @Override
  public Mono<TransactionResponseDto> createTransaction(TransactionRequestDto requestDto) {
    return userRepository
        .updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
        .filter(Boolean::booleanValue)
        .map(i -> EntityMapper.dtoToUserTransaction(requestDto))
        .flatMap(transactionRepository::save)
        .map(
            userTransaction ->
                EntityMapper.transactionRequestToResponse(requestDto, TransactionStatus.APPROVED))
        .defaultIfEmpty(
            EntityMapper.transactionRequestToResponse(requestDto, TransactionStatus.DECLINED));
  }
}
