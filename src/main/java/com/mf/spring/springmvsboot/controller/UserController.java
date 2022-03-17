package main.java.com.mf.spring.springmvsboot.controller;

import com.mf.spring.springmvsboot.database.DataBaseInit;
import com.mf.spring.springmvsboot.model.User;
import com.mf.spring.springmvsboot.service.RoleService;
import com.mf.spring.springmvsboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService, RoleService roleService, DataBaseInit init) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getSinglePage(@AuthenticationPrincipal User authUser, Model model) {
        model.addAttribute("authUser", authUser);
        return "users";
    }

}