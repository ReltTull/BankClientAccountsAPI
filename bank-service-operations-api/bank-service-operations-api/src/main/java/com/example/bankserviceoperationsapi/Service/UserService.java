package com.example.bankserviceoperationsapi.Service;

import com.example.bankserviceoperationsapi.Entity.User;
import com.example.bankserviceoperationsapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public synchronized User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public synchronized void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public synchronized void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public synchronized void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Transactional
    public synchronized Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
