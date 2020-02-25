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

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

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