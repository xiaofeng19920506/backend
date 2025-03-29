package com.ucomputersa.monolithic.service;

import com.ucomputersa.monolithic.domain.User;

import java.util.Optional;

public interface UserService {
    User findUserByIdWithValidation(String userId);

    Optional<User> findUserById(String userId);


}
