package main.java.com.mf.spring.springmvsboot.service;

import com.mf.spring.springmvsboot.DAO.UserDAO;
import com.mf.spring.springmvsboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            if (userDAO.getUserByUsername(user.getUsername()) != null) {
                throw new NonUniqueResultException("Ошибка. Username '" + user.getUsername() + "' уже занят.");
            }
        } catch (EmptyResultDataAccessException | NoResultException ignored) {
        }
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User daouser;
        Long daouserId;

        try {
            daouser = userDAO.getUserByUsername(user.getUsername());
            daouserId = daouser.getId();
            if (!Objects.equals(daouserId, user.getId())) {
                throw new NonUniqueResultException("Ошибка.Username '" + user.getUsername() +  "' уже занят.");
            }
        } catch (EmptyResultDataAccessException | NoResultException ignored) {
        }

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(getUser(user.getId()).getPassword());
        }
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void saveUsers(User... user) {
        Arrays.stream(user).forEach(this::saveUser);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) throws EntityNotFoundException {
        userDAO.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
