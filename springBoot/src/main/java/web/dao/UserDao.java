package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getUsers();

    public void addUser(User user);

    public void deleteUser(Long id);

    public void updateUser(Long id, String name, String lastName, byte age);
}
