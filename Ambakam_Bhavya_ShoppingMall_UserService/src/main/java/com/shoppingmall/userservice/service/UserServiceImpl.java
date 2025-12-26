package com.shoppingmall.userservice.service;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.userservice.entity.User;
import com.shoppingmall.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {

        // DEBUG
        System.out.println("RAW PASSWORD FROM REQUEST: " + user.getPassword());

        // ENCRYPT PASSWORD
        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        // SET BACK TO USER
        user.setPassword(encryptedPassword);

        // SAVE USER
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        userRepository.delete(user);
    }
}