package com.azubike.ellipsis.usermcs.repository;

import com.azubike.ellipsis.usermcs.entities.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserTransactionRepository
    extends ReactiveCrudRepository<UserTransaction, Integer> {
  Flux<UserTransaction> findByUserId(int userId);
}
