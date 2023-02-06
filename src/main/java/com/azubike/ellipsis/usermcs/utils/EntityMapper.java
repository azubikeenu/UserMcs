package com.azubike.ellipsis.usermcs.utils;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.request.UserDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionResponseDto;
import com.azubike.ellipsis.usermcs.dto.response.TransactionStatus;
import com.azubike.ellipsis.usermcs.dto.response.UserTransactionResponseDto;
import com.azubike.ellipsis.usermcs.entities.User;
import com.azubike.ellipsis.usermcs.entities.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityMapper {
  public static UserDto userToDto(User user) {
    final UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  public static User dtoToUser(UserDto userDto) {
    final User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  public static UserTransaction dtoToUserTransaction(TransactionRequestDto transactionRequestDto) {
    final UserTransaction userTransaction = new UserTransaction();
    userTransaction.setAmount(transactionRequestDto.getAmount());
    userTransaction.setUserId(transactionRequestDto.getUserId());
    userTransaction.setTransactionDate(LocalDateTime.now());
    return userTransaction;
  }

  public static TransactionResponseDto transactionRequestToResponse(
      TransactionRequestDto requestDto, TransactionStatus status) {
    TransactionResponseDto responseDto = new TransactionResponseDto();
    responseDto.setUserId(requestDto.getUserId());
    responseDto.setAmount(requestDto.getAmount());
    responseDto.setStatus(status);

    return responseDto;
  }

  public static UserTransactionResponseDto userTransactionToResponse(
      UserTransaction userTransaction) {
    UserTransactionResponseDto userTransactionResponseDto = new UserTransactionResponseDto();
    userTransactionResponseDto.setAmount(userTransaction.getAmount());
    userTransactionResponseDto.setUserId(userTransaction.getUserId());
    userTransactionResponseDto.setTransactionDate(userTransaction.getTransactionDate());
    return userTransactionResponseDto;
  }
}
