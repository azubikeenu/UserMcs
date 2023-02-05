package com.azubike.ellipsis.usermcs.service.user;

import com.azubike.ellipsis.usermcs.dto.request.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
  Flux<UserDto> getAllUsers();

  Mono<UserDto> getUserById(int id);

  Mono<UserDto> createUser(Mono<UserDto> userDtoMono);

  Mono<Void> deleteUser(int id);

  Mono<UserDto> updateUser(Mono<UserDto> userDtoMono , int id );
}
