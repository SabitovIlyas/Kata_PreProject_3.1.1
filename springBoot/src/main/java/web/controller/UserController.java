package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestParam String name, @RequestParam String lastName, @RequestParam byte age) {
        userService.addUser(new User(name, lastName, age));
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String lastName,
                             @RequestParam byte age) {
        userService.updateUser(id, name, lastName, age);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}