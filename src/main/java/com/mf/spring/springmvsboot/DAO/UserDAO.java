package main.java.com.mf.spring.springmvsboot.DAO;

import com.mf.spring.springmvsboot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    User getUserByUsername(String name);
}
