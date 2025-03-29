package com.ucomputersa.monolithic.repository;

import com.ucomputersa.monolithic.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
}
