package com.azubike.ellipsis.usermcs.utils;

import com.azubike.ellipsis.usermcs.dto.request.TransactionRequestDto;
import com.azubike.ellipsis.usermcs.dto.request.UserDto;
import com.azubike.ellipsis.usermcs.entities.User;
import com.azubike.ellipsis.usermcs.entities.UserTransaction;
import org.springframework.beans.BeanUtils;

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
    BeanUtils.copyProperties(transactionRequestDto, userTransaction);
    return userTransaction;
  }

  public static TransactionRequestDto  userTransactionToDto(UserTransaction userTransaction){
      final TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
      BeanUtils.copyProperties(userTransaction , transactionRequestDto);
      return transactionRequestDto;
  }
}
