package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.User;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("u");
        userService.saveUser(user);
//        return "user";
        return "Logon details: " + user.getUsername() + " " + user.getPassword() + " " + user.getRoles();
    }


    @GetMapping("/user-old")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
//        log.info("customUsSer class {} " , customUser.getClass());
//        log.info("customUsSer class {} " , customUser.getClass());
        return "You are logged as " + customUser;
    }

    @GetMapping("/user")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

}