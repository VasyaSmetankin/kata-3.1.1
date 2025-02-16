package org.smetankin.kata3112.service;

import org.smetankin.kata3112.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
}

