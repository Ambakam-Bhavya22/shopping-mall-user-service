package com.shoppingmall.userservice.service;

import java.util.List;
import com.shoppingmall.userservice.entity.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}

