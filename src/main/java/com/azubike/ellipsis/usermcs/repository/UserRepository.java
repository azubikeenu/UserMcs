package com.azubike.ellipsis.usermcs.repository;

import com.azubike.ellipsis.usermcs.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {}
