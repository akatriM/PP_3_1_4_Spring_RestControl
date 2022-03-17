package main.java.com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    void saveRole(Role role);

    Role getRole(Long id);

    Role getRoleByName(String name);

    void deleteRole(Long id);
}
