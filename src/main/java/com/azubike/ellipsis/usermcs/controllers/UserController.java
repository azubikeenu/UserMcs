package com.azubike.ellipsis.usermcs.controllers;

import com.azubike.ellipsis.usermcs.dto.request.UserDto;
import com.azubike.ellipsis.usermcs.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserDto> getUserById(@PathVariable("id") int id) {
    return userService.getUserById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDto) {
    return userService.createUser(userDto);
  }

  @PutMapping(
      value = "{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserDto> updateUser(
      @PathVariable("id") int id, @RequestBody Mono<UserDto> userDtoMono) {
    return userService.updateUser(userDtoMono.map(userDto -> userDto.withId(id)), id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping(value = "{id}")
  public Mono<Void> deleteUser(@PathVariable("id") int id) {
    return userService.deleteUser(id);
  }
}
