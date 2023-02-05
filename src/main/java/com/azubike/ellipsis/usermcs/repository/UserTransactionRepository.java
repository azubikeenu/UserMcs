package com.azubike.ellipsis.usermcs.repository;

import com.azubike.ellipsis.usermcs.entities.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {
}
