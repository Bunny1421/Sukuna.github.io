package com.cpe.sukuna.service;

import com.cpe.sukuna.controller.UserAddForm;
import com.cpe.sukuna.entity.User;
import com.cpe.sukuna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncider passwordEncider;

    public UserService(UserRepository userRepository, PasswordEncider passwordEncider) {
        this.userRepository = userRepository;
        this.passwordEncider = passwordEncider;
    }

    public void createUser(UserAddForm userAddForm) throws NoSuchAlgorithmException {
        User user = new User();
        user.setUSER_NAME(userAddForm.getName());
        user.setUSER_EMAIL(userAddForm.getEmail());
        user.setUSER_PASS(passwordEncider.hashMD5(userAddForm.getPassword()));
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public List<User> findUser(String s){
        return userRepository.findUserByUSER_NAME(s);
    }

}
