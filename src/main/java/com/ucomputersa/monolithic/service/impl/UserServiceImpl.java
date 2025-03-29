package com.ucomputersa.monolithic.service.impl;

import com.ucomputersa.monolithic.domain.User;
import com.ucomputersa.monolithic.repository.UserRepository;
import com.ucomputersa.monolithic.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByIdWithValidation(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Invalid UserId "));
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return userRepository.findById(userId);
    }
}
