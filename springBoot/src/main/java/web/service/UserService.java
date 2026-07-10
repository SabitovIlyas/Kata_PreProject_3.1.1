package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, String name, String lastName, byte age);
}

