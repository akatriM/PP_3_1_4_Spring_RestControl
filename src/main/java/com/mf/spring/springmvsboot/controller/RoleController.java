package main.java.com.mf.spring.springmvsboot.controller;

import com.mf.spring.springmvsboot.database.DataBaseInit;
import com.mf.spring.springmvsboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RoleController {
    private DataBaseInit init;
    private UserService userService;

    @Autowired
    public RoleController(DataBaseInit init, UserService userService) {
        this.init = init;
        this.userService = userService;
    }

    @GetMapping("")
    public String rootBoot(){
        if (userService.getAllUsers().isEmpty()){
            init.addUsersToDB();
        }
        return "redirect:/login";
    }
}
