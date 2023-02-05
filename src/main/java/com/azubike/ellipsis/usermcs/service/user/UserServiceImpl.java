package com.azubike.ellipsis.usermcs.service.user;

import com.azubike.ellipsis.usermcs.dto.request.UserDto;
import com.azubike.ellipsis.usermcs.repository.UserRepository;
import com.azubike.ellipsis.usermcs.utils.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public Flux<UserDto> getAllUsers() {
    return userRepository.findAll().map(EntityMapper::userToDto);
  }

  @Override
  public Mono<UserDto> getUserById(int id) {
    return userRepository
        .findById(id)
        .map(EntityMapper::userToDto)
        .switchIfEmpty(monoResponseStatusNotFoundException(id));
  }

  @Override
  public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
    return userDtoMono
        .map(EntityMapper::dtoToUser)
        .flatMap(userRepository::save)
        .map(EntityMapper::userToDto);
  }

  @Override
  public Mono<Void> deleteUser(int id) {
    return this.getUserById(id).map(EntityMapper::dtoToUser).flatMap(userRepository::delete);
  }

  @Override
  public Mono<UserDto> updateUser(Mono<UserDto> userDtoMono, int id) {
    return userRepository
        .findById(id)
        .flatMap(
            p ->
                userDtoMono.map(
                    EntityMapper
                        ::dtoToUser)) // this step converts the userDto to a product entity
        .flatMap(userRepository::save)
        .map(EntityMapper::userToDto);
  }

  private <T> Mono<T> monoResponseStatusNotFoundException(int id) {
    return Mono.error(
        new ResponseStatusException(
            HttpStatus.NOT_FOUND, "user  with given id : " + id + " Not found"));
  }
}
