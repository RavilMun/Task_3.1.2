package web.Task_312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Task_312.model.User;
import web.Task_312.service.UserService;

import java.util.List;


@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        List<User> users = userService.index();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("new")
    public String addUser(@ModelAttribute("user") Model model) {
        return "users/index";
    }

    @PostMapping()
    public String create(@ModelAttribute("users") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("edit")
    public String editUser(@RequestParam("id") Long userId, Model model) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/edit")
    public String editUserSubmit(@ModelAttribute User editedUser) {
        userService.update(editedUser);
        return "redirect:/users";
    }

    @GetMapping("delete")
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "users/index";
    }

    @PostMapping("/delete")
    public String deleteUserSubmit(@ModelAttribute User user) {
        userService.delete(user.getId());
        return "redirect:/users";
    }
}