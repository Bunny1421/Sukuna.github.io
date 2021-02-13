package com.cpe.sukuna.repository;

import com.cpe.sukuna.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(
            value = "select * from user where USER_NAME = ?1",
            nativeQuery = true)
    List<User> findUserByUSER_NAME(String s);
}
