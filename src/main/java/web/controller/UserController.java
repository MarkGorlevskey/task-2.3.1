package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUser(Model model) {
        List<User> list = userService.getAllUser();
        model.addAttribute("userList", list);
        return "userList";
    }

    @GetMapping("/selectUserFromId/{id}")
    public String selectUserFromId(@PathVariable int id, Model model) {
        User user = userService.selectUserFromId(id);
        model.addAttribute("user", user);
        return "search";
    }

    @PutMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user.getName(), user.getLastName(), user.getAge(), user.getPhoneNumber(), user.getEmail());
        return "saveUser";
    }

    @DeleteMapping("/removeUser/{id}")
    public String removeUser(@ModelAttribute("user") User user) {
        userService.removeUser(user);
        return "redirect:/";
    }

    @PatchMapping("/updateUser/{id}")
    public String changeUserById(@PathVariable int id, @ModelAttribute User user) {
        userService.changeUserInfoById(id, user);
        return "redirect:/";
    }
}
