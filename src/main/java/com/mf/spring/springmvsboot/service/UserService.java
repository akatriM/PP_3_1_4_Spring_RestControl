package main.java.com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void saveUsers(User ... user);

    User getUser(Long id);

    void deleteUser(Long id);
}
