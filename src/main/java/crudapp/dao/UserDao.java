package crudapp.dao;

import crudapp.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUserById(int id);
    User getUserByName(String name);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
