package crudapp.dao;

import crudapp.model.Role;
import crudapp.model.User;

import java.util.List;

public interface RoleDao {
    void add(Role role);
    List<Role> listRoles();
    Role getRoleByName(String name);
}
