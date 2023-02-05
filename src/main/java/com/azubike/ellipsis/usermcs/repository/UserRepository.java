package com.azubike.ellipsis.usermcs.repository;

import com.azubike.ellipsis.usermcs.entities.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
  @Modifying
  @Query("UPDATE users SET balance = balance - :amount WHERE id = :id AND balance >= :amount")
  Mono<Boolean> updateUserBalance(int id, int amount);
}
