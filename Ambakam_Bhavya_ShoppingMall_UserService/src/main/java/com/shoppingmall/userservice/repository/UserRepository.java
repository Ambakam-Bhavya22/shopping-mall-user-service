package com.shoppingmall.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shoppingmall.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}



