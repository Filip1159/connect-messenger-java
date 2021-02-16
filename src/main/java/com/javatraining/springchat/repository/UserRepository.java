package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECt u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
