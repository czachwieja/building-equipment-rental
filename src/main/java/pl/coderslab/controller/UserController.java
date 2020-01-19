package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "Logon details: " + user.getUsername() + " " + user.getPassword() + " " + user.getRoles();
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

//    @GetMapping("/create-admin")
//    @ResponseBody
//    public String createAdmin() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("a");
//        userService.saveUser(user);
//        return "Logon details: " + user.getUsername() + " " + user.getPassword() + " " + user.getRoles();
//    }
//
//    @GetMapping("/create-admin2")
//    @ResponseBody
//    public String createAdmin2() {
//        User user = new User();
//        user.setUsername("admin2");
//        user.setPassword("a");
//        userService.saveUser(user);
//        return "Logon details: " + user.getUsername() + " " + user.getPassword() + " " + user.getRoles();
//    }

    @GetMapping("/user")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
        return "You are logged as " + customUser;
    }

    @GetMapping("/user-hello")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

}