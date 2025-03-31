package com.LibraryManagement.LibMgm.Service;

import com.LibraryManagement.LibMgm.Entitiy.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    void deleteUser(Long userId);

    Optional<User> getUserByEmail(String email);
}
