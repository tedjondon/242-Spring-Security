package crudapp.service;

import crudapp.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserById(int id);
    User getUserByName(String name);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
